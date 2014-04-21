package dm.athens.parser;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import dm.athens.booking.Booking;
import dm.athens.booking.BookingCSV;
import dm.athens.booking.Booking_charge;
import dm.dao.GlobalDB;

/**
 * Parses CSV Data File
 * 
 * @author Vincent Lee
 * @since April 18, 2014
 * @version 1.0
 */

public class BookingCSVParser {
	private CSVStream stream;
	private Map<Integer, Booking> bookingMap;
	private GlobalDB global;
	
	public BookingCSVParser(String filename) {
		stream = new CSVStream();
		stream.openCVSFile(filename);
		bookingMap = new HashMap<Integer, Booking>();
		global = new GlobalDB();
	}
	
	public void parse() {
		int counter = 0;
		while (stream.next()) {
			BookingCSV csv = stream.nextBooking();
			
			if (csv == null)
				continue;
			
			counter++;
			
			if (bookingMap.containsKey(csv.getMid_number())) {
				bookingMap.get(csv.getMid_number()).addCharge(new Booking_charge(csv.getBooking_date(), csv.getRelease_date(), 
						csv.getArresting_agency(), csv.getCrime_type(), csv.getCharge(), csv.getCourt_jurisdiction(), csv.getBonding_company(), 
						csv.getBonding_amount(), null, csv.getWarrant_number(), csv.getPolice_case_number()));
				continue;
			}
			
			
			Booking booking = new Booking(csv.getMid_number(), csv.getFirstname(), csv.getLastname(), 
					csv.getYear_of_birth(), csv.getRace(), csv.getSex(), 0, 0, false);
			
			booking.addCharge(new Booking_charge(csv.getBooking_date(), csv.getRelease_date(), csv.getArresting_agency(), 
					csv.getCrime_type(), csv.getCharge(), csv.getCourt_jurisdiction(), csv.getBonding_company(), 
					csv.getBonding_amount(), null, csv.getWarrant_number(), csv.getPolice_case_number()));
			bookingMap.put(csv.getMid_number(), booking);
			
		}
		System.out.println(counter);
	}
	
	public void tableToSQL() {
		try {
			global.openDBconnection();
			
			for (Map.Entry<Integer, Booking> entry : bookingMap.entrySet()) {
				Integer key = entry.getKey();
				Booking value = entry.getValue();
				
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
				
				int last_insert_id = 1;
				ResultSet rs = global.select_last_insert_id.executeQuery();
				if (rs.next()) last_insert_id = rs.getInt(1);
				
				for (Booking_charge instance : value.getCharges()) {
					global.insert_booking_charge.setInt(1, last_insert_id);
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
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			global.closeDBconnection();
		}
	}
	
	/**
	 * Main
	 * @param args filename.csv
	 */
	public static void main(String[] args) {
		BookingCSVParser bookingCSV = new BookingCSVParser(args[0]);
		bookingCSV.parse();
		bookingCSV.tableToSQL();
	}
}
