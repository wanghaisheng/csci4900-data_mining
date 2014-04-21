package dm.athens.parser;

/**
 * Parses Current Prisoner List asp page
 * CURRENT PRISONER LISTING-DISPLAYS FIRST CHARGE ONLY
 * 
 * @author Vincent Lee
 * @since April 14, 2014
 * @version 1.0
 */

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dm.athens.jail.*;
import dm.dao.GlobalDB;

public class JailParser {
	protected static final boolean DEBUG = false;
	protected List<Jail> jailList;
	protected Document doc;
	protected GlobalDB global;
	protected Date lastUpdate;
	
	public JailParser() {
		this.jailList = new ArrayList<Jail>();
		this.global = new GlobalDB();
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
	
	@SuppressWarnings("deprecation")
	public void parseTable() {
		try {
			//Get the Last Updated time
			Elements lastUpdateDiv = doc.select("DIV");
			
			String update = lastUpdateDiv.text();
			int firstColon = update.indexOf(":"); //first ":"
			update = update.substring(firstColon+2); //remove "Last Updated: "
			SimpleDateFormat lastUpdateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa"); // 4/14/2014 6:00:00 PM 
			lastUpdate = lastUpdateFormat.parse(update);
			
			//Get the table
			Elements table = doc.select("tr");
			
			//Table Rows
			for (Element row : table) {
				//Table Columns
				Elements column = row.select("td");
				
				//Row with no data
				if (column.size() == 0) continue;
				
				//MID#
				int mid_number = Integer.parseInt(column.get(0).text());
				
				//NAME
				String name = column.get(1).text();
				name = name.replace("\u00a0"," "); //remove "&nbsp;"
				int firstComma = name.indexOf(','); //split on last name
				String firstname = name.substring(firstComma+2);
				String lastname = name.substring(0, firstComma);
				
				//SEX
				String sex = column.get(2).text();
				
				//RACE
				String race = column.get(3).text();
				
				//BOOKING DATE
				SimpleDateFormat bookingFormat = new SimpleDateFormat("MM/dd/yyyyhh:mm aa"); // 3/10/20141:15 P.M.
				String date = column.get(4).text().replace("\u00a0",""); //remove "&nbsp;"
				date = date.replace(".", ""); //Fix "P.M." -> "PM"
				Date booking_date = bookingFormat.parse(date);
				
				//CHARGE
				String charge = column.get(5).text();
				
				//BOND AMOUNT
				String bond = column.get(6).text().substring(1).replace(",", ""); //remove $ and ","
				double bond_amount = Double.parseDouble(bond);
				
				//CASE NUMBER
				String case_number = column.get(7).text().replace("\u00a0",""); //remove "&nbsp;"
				if (case_number.equals("")) case_number = null; //no case number -> null
				
				//POLICE CASE#
				String police_case_number = column.get(8).text().replace("\u00a0",""); //remove "&nbsp;"
				if (police_case_number.equals("")) police_case_number = null; //no police case # -> null
				
				//YEAR OF BIRTH
				String year_of_birth = column.get(9).text();
				
				//VISITATION
				String visitation = column.get(10).text();
				if (visitation.length() == 0)
					visitation = null;
				
				if (DEBUG) {
					System.out.println("mid_number-" + mid_number);
					System.out.println("firstname-" + firstname);
					System.out.println("lastname-" + lastname);
					System.out.println("sex-" + sex);
					System.out.println("race-" + race);
					System.out.println("booking_date-" + booking_date.toLocaleString());
					System.out.println("charge-" + charge);
					System.out.println("bond_amount-" + bond_amount);
					System.out.println("case_number-" + case_number);
					System.out.println("police_case_number-" + police_case_number);
					System.out.println("year_of_birth-" + year_of_birth);
					System.out.println("visitation-" + visitation);
				}

				jailList.add(new Jail(mid_number, firstname, lastname, sex, race, booking_date, charge, bond_amount, case_number, police_case_number, year_of_birth, visitation));
			}
			
			if (DEBUG) System.out.println("Rows: " + table.size());
			if (DEBUG) System.out.println("Actual Rows(rows-header-blank): " + jailList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void tableToSQL() {
		try {
			global.openDBconnection();
			
			for (Jail instance : jailList) {
				try {
					global.insert_jail.setInt(1, instance.getMid_number());
					global.insert_jail.setString(2, instance.getFirstname());
					global.insert_jail.setString(3, instance.getLastname());
					global.insert_jail.setString(4, instance.getSex());
					global.insert_jail.setString(5, instance.getRace());
					global.insert_jail.setTimestamp(6, new Timestamp(instance.getBooking_date().getTime()));
					global.insert_jail.setString(7, instance.getCharge());
					global.insert_jail.setDouble(8, instance.getBond_amount());
					global.insert_jail.setString(9, instance.getCase_number());
					global.insert_jail.setString(10, instance.getPolice_case_number());
					global.insert_jail.setString(11, instance.getYear_of_birth());
					global.insert_jail.setString(12, instance.getVisitation());
					global.insert_jail.setTimestamp(13, new Timestamp(lastUpdate.getTime()));
					global.insert_jail.execute();
				} catch (Exception e) {
					System.out.println(instance);
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			global.closeDBconnection();
		}
	}
	
	/**
	 * Main
	 * @param args filename
	 */
	public static void main(String[] args) {
		JailParser jailParser = new JailParser();
		jailParser.openFile(args[0]);
		jailParser.parseTable();
		jailParser.tableToSQL();
	}
}
