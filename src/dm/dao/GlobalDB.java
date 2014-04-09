package dm.dao;

/**
 * Data Access Object
 * 
 * @author Vincent Lee
 * @since April 8, 2014
 * @version 1.0
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.UUID;

public class GlobalDB {
	//Student Listings
	public PreparedStatement insert_student_listings;
	public PreparedStatement insert_sl_phone;
	public PreparedStatement insert_sl_address;
	
	//Faculty and Staff
	public PreparedStatement insert_faculty_and_staff;
	public PreparedStatement insert_fas_phone;
	public PreparedStatement insert_fas_address;
	
	//Tools
	public PreparedStatement disable_foreignkey;
	public PreparedStatement select_last_insert_id;
	
	private Connection conn;
	private UUID uuid;
	
	public GlobalDB() {}
	
	public void openDBconnection() {
		try {
            //Connect to database
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/dm", "root", "");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost/team4", "team4", "seprocess");
			uuid = UUID.randomUUID();
			System.out.println("<Connected to MySQL " + uuid.toString().substring(0, 8) + ">");
			
			//Prepared statements used to query database
			//Student Listings
			insert_student_listings = conn.prepareStatement("INSERT INTO student_listings(firstname,middlename,lastname,email,year_start,year_end) VALUES(?,?,?,?,?,?)");
			
			//Student Listings - Phone Number
			insert_sl_phone = conn.prepareStatement("INSERT INTO sl_phone(sl_id,country_code,area_code,exchange_code,line_number,extension) VALUES(?,?,?,?,?,?)");
			
			//Student Listings - Address
			insert_sl_address = conn.prepareStatement("INSERT INTO sl_address(sl_id_1,name,room,street_1,street_2,city,state,zip,zip_4,country) VALUES(?,?,?,?,?,?,?,?,?,?)");
			
			//Faculty and Staff
			insert_faculty_and_staff = conn.prepareStatement("INSERT INTO faculty_and_staff(title,firstname,middlename,lastname,suffix,email) VALUES(?,?,?,?,?,?)");
			
			//Faculty and Staff - Phone Number
			insert_fas_phone = conn.prepareStatement("INSERT INTO fas_phone(fas_id,fas_address_id,country_code,area_code,exchange_code,line_number,extension) VALUES(?,?,?,?,?,?,?)");
			
			//Faculty and Staff - Address
			insert_fas_address = conn.prepareStatement("INSERT INTO fas_address(fas_id_1,name,street_1,street_2,city,state,zip,zip_4,country) VALUES(?,?,?,?,?,?,?,?,?)");
			
			
			
			//Tool
			disable_foreignkey = conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 0");
			select_last_insert_id = conn.prepareStatement("select LAST_INSERT_ID()");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void closeDBconnection() {
		try {
			conn.close();
			System.out.println("<Disconnected from MySQL " + uuid.toString().substring(0, 8) + ">");
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
