package dm.athens.parser;

import java.io.File;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dm.athens.booking.Booking;
import dm.athens.booking.Booking_charge;
import dm.dao.GlobalDB;

/**
 * Parses HTML File
 * 
 * @author Vincent Lee
 * @since April 24, 2014
 * @version 1.0
 */

public class BookingParser {
	private static final boolean DEBUG = false;
//	private final String detailsFront = "http://api.athensclarkecounty.com/sheriff/jail/details.asp?id=";
//	private final String detailsEnd = "&pg=2";
	private Map<Integer, Booking> bookingMap;
	private GlobalDB global;
	private Document doc;
	private Date lastUpdate;
	
	public BookingParser() {
		this.global = new GlobalDB();
		this.bookingMap = new HashMap<Integer, Booking>();
	}
	
	public boolean openFile(String filename) {
		try {
			doc = Jsoup.parse(new File(filename), "UTF-8");
			return true;
		} catch (Exception e) {
			System.out.println("error: openFile(" + filename + ")");
			return false;
		}
	}
	
	public void parseTable() {
		try {
			//Get the Last Updated time
			Elements lastUpdateDiv = doc.select("DIV");
			
			String update = lastUpdateDiv.text();
			int firstColon = update.indexOf(":"); //first ":"
			update = update.substring(firstColon+2); //remove "Last Updated: "
			SimpleDateFormat lastUpdateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa"); // 4/14/2014 6:00:00 PM 
			lastUpdate = lastUpdateFormat.parse(update);
			if (DEBUG) System.out.println(lastUpdate.toLocaleString());
			
			//Get the table
			Elements table = doc.select("tr");
			
			//Debugger
			int counter = 0;
			
			//Table Rows
			for (Element row : table) {
				//Table Columns
				Elements column = row.select("td");
				
				//Row with no data
				if (column.size() == 0) continue;
				
				//MID#
				int mid_number = Integer.parseInt(column.get(0).text());
				
				//BOOKING DATE
				SimpleDateFormat bookingFormat = new SimpleDateFormat("MM/dd/yyyyhh:mm aa"); // 3/10/20141:15 P.M.
				String date = column.get(1).text().replace("\u00a0",""); //remove "&nbsp;"
				date = date.replace(".", ""); //Fix "P.M." -> "PM"
				Date booking_date = bookingFormat.parse(date);
				
				//NAME
				String name = column.get(2).text();
				name = name.replace("\u00a0"," "); //remove "&nbsp;"
				int firstComma = name.indexOf(','); //split on last name
				String firstname = name.substring(firstComma+2);
				String lastname = name.substring(0, firstComma);
				
				//YEAR OF BIRTH
				String year_of_birth = column.get(3).text();
				
				//RACE
				String race = column.get(4).text();
				
				//SEX
				String sex = column.get(5).text();
				
				//ARRESTING AGENCY
				String arresting_agency = column.get(6).text();
				
				//RELEASE TIME
				String date1 = column.get(7).text().replace("\u00a0",""); //remove "&nbsp;"
				Date release_date = null;
				if (!date1.isEmpty()) {
					date1 = date1.replace(".", ""); //Fix "P.M." -> "PM"
					release_date = bookingFormat.parse(date1);
				}
				
				//CHARGE
				String charge = column.get(8).text();
				
				//CRIME TYPE
				String crime_type = column.get(9).text();
				
				//COURT JURISDICTION
				String court_jurisdiction = column.get(10).text().replace("\u00a0","");
				if (court_jurisdiction.isEmpty()) court_jurisdiction = null;
				
				//BONDING COMPANY
				String bonding_company = column.get(11).text().replace("\u00a0","");
				if (bonding_company.isEmpty()) bonding_company = null;
				
				//BOND AMOUNT
				String bond = column.get(12).text().substring(1).replace(",", ""); //remove $ and ","
				double bond_amount = Double.parseDouble(bond);
				
				//WARRANT #
				String warrant_number = column.get(13).text().replace("\u00a0",""); //remove "&nbsp;"
				if (warrant_number.isEmpty()) warrant_number = null;
				
				//POLICE CASE#
				String police_case_number = column.get(14).text().replace("\u00a0",""); //remove "&nbsp;"
				if (police_case_number.isEmpty()) police_case_number = null; //no police case # -> null
				
			
				
				
				if (DEBUG) {
					System.out.println(mid_number);
					System.out.println(booking_date.toLocaleString());
					System.out.println(firstname);
					System.out.println(lastname);
					System.out.println(year_of_birth);
					System.out.println(race);
					System.out.println(sex);
					System.out.println(arresting_agency);
					System.out.println(release_date);
					System.out.println(charge);
					System.out.println(crime_type);
					System.out.println(court_jurisdiction);
					System.out.println(bonding_company);
					System.out.println(bond_amount);
					System.out.println(warrant_number);
					System.out.println(police_case_number);
					System.out.println();
					
					if (++counter == 2) break;
				}
				
				
				/*
				 * Load Map
				 */
				if (bookingMap.containsKey(mid_number)) {
					bookingMap.get(mid_number).addCharge(new Booking_charge(booking_date, release_date, 
							arresting_agency, crime_type, charge, court_jurisdiction, bonding_company, 
							bond_amount, null, warrant_number, police_case_number));
					continue;
				}
				
				
				Booking booking = new Booking(mid_number, firstname, lastname, 
						year_of_birth, race, sex, 0, 0, false);
				
				booking.addCharge(new Booking_charge(booking_date, release_date, arresting_agency, 
						crime_type, charge, court_jurisdiction, bonding_company, bond_amount, 
						null, warrant_number, police_case_number));
				bookingMap.put(mid_number, booking);
			}
			
			if (DEBUG) System.out.println(bookingMap.size());
//			System.out.println(bookingMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void tableToSQL() {
		try {
			global.openDBconnection();
			
			for (Map.Entry<Integer, Booking> entry : bookingMap.entrySet()) {
				Integer key = entry.getKey();
				Booking value = entry.getValue();
				
				int SQL_ID = 0;
				
				//check if user is already in database
				//Get SQL auto increment id (used as foreign key)
				global.select_id_from_booking_where_mid_number.setInt(1, key);
				ResultSet rs = global.select_id_from_booking_where_mid_number.executeQuery();
				if (rs.next()) SQL_ID = rs.getInt("id");
				
				if (DEBUG) System.out.println("sql_id" + SQL_ID);
				
				//If user is not in booking table -- add
				if (SQL_ID == 0) {
					global.insert_booking.setInt(1, key);
					global.insert_booking.setString(2, value.getFirstname());
					global.insert_booking.setString(3, value.getLastname());
					global.insert_booking.setString(4, value.getYear_of_birth());
					global.insert_booking.setString(5, value.getRace());
					global.insert_booking.setString(6, value.getSex());
					global.insert_booking.setInt(7, value.getHeight());
					global.insert_booking.setInt(8, value.getWeight());
					global.insert_booking.setBoolean(9, false);
					global.insert_booking.execute();
					
					rs = global.select_last_insert_id.executeQuery();
					if (rs.next()) SQL_ID = rs.getInt(1);
					if (DEBUG) System.out.println("sql_idx" + SQL_ID);
				}
				
				
				
				
				for (Booking_charge instance : value.getCharges()) {
					int BOOKING_CHARGE_ID = 0;
					if (SQL_ID != 0) {
						global.select_id_from_booking_charge_where_booking_idx_and_booking_date_and_charge_description.setInt(1, SQL_ID);
						global.select_id_from_booking_charge_where_booking_idx_and_booking_date_and_charge_description.setTimestamp(2, new Timestamp(instance.getBooking_date().getTime()));
						global.select_id_from_booking_charge_where_booking_idx_and_booking_date_and_charge_description.setString(3, instance.getCharge_description());
						rs = global.select_last_insert_id.executeQuery();
						if (rs.next()) BOOKING_CHARGE_ID = rs.getInt(1);
					}
					
					if (BOOKING_CHARGE_ID != 0) {
						global.update_booking_charge_where_id.setTimestamp(1, new Timestamp(instance.getBooking_date().getTime()));
						global.update_booking_charge_where_id.setTimestamp(2, (instance.getRelease_date() == null) ? null : new Timestamp(instance.getRelease_date().getTime()));
						global.update_booking_charge_where_id.setString(3, instance.getArresting_agency());
						global.update_booking_charge_where_id.setString(4, instance.getGrade_of_charge());
						global.update_booking_charge_where_id.setString(5, instance.getCharge_description());
						global.update_booking_charge_where_id.setString(6, instance.getCourt_jurisdiction());
						global.update_booking_charge_where_id.setString(7, instance.getBonding_company());
						global.update_booking_charge_where_id.setDouble(8, instance.getBonding_amount());
						global.update_booking_charge_where_id.setString(9, instance.getDisposition());
						global.update_booking_charge_where_id.setString(10, instance.getWarrant_number());
						global.update_booking_charge_where_id.setString(11, instance.getPolice_case_number());
						global.update_booking_charge_where_id.setTimestamp(12, new Timestamp(lastUpdate.getTime()));
						global.update_booking_charge_where_id.setInt(13, BOOKING_CHARGE_ID);
						global.update_booking_charge_where_id.executeUpdate();
					} else {
						global.insert_booking_charge.setInt(1, SQL_ID);
						global.insert_booking_charge.setTimestamp(2, new Timestamp(instance.getBooking_date().getTime()));
						global.insert_booking_charge.setTimestamp(3, (instance.getRelease_date() == null) ? null : new Timestamp(instance.getRelease_date().getTime()));
						global.insert_booking_charge.setString(4, instance.getArresting_agency());
						global.insert_booking_charge.setString(5, instance.getGrade_of_charge());
						global.insert_booking_charge.setString(6, instance.getCharge_description());
						global.insert_booking_charge.setString(7, instance.getCourt_jurisdiction());
						global.insert_booking_charge.setString(8, instance.getBonding_company());
						global.insert_booking_charge.setDouble(9, instance.getBonding_amount());
						global.insert_booking_charge.setString(10, instance.getDisposition());
						global.insert_booking_charge.setString(11, instance.getWarrant_number());
						global.insert_booking_charge.setString(12, instance.getPolice_case_number());
						global.insert_booking_charge.setTimestamp(13, null);
						global.insert_booking_charge.execute();
					}
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			global.closeDBconnection();
		}
	}
	
	public static void main(String[] args) {
		BookingParser parser = new BookingParser();
		parser.openFile("04-26-2014.html");
		parser.parseTable();
		parser.tableToSQL();
	}
}