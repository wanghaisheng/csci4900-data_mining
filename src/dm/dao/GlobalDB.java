/*
 * Copyright (c) 2014, vincentclee <ssltunnelnet@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

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
	
	//Faculty and Staff
	public PreparedStatement insert_faculty_and_staff;
	
	//Jail
	public PreparedStatement insert_jail;
	
	//Jailx
	public PreparedStatement insert_jailx;
	public PreparedStatement insert_jailx_address;
	public PreparedStatement insert_jailx_charge;
	
	//Booking
	public PreparedStatement insert_booking;
	public PreparedStatement insert_booking_address;
	public PreparedStatement insert_booking_charge;
	public PreparedStatement select_id_from_booking_where_mid_number;
	public PreparedStatement select_id_from_booking_charge_where_booking_idx_and_booking_date_and_charge_description;
	public PreparedStatement update_booking_charge_where_id;
	public PreparedStatement select_boocking_charge_where_grade_of_charge;
	public PreparedStatement update_booking_charge_where_id_grade_of_charge;
	
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
			uuid = UUID.randomUUID();
			System.out.println("<MySQL " + uuid.toString().substring(0, 8) + " Connected>");
			
			//Prepared statements used to query database
			//Student Listings
			insert_student_listings = conn.prepareStatement("INSERT INTO student_listings(firstname,lastname) VALUES(?,?)");
			
			//Faculty and Staff
			insert_faculty_and_staff = conn.prepareStatement("INSERT INTO faculty_and_staff(firstname,lastname) VALUES(?,?)");
			
			//Jail
			insert_jail = conn.prepareStatement("INSERT INTO jail(mid_number,firstname,lastname,sex,race,booking_date,charge,bond_amount,case_number,police_case_number,year_of_birth,visitation,last_update) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			//Jailx
			insert_jailx = conn.prepareStatement("INSERT INTO jailx(mid_number,firstname,lastname,sex,race,year_of_birth,height,weight,booking_date,released_date,bond_amount,case_number,police_case_number,visitation,photo,last_update) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			//Jailx - Address
			insert_jailx_address = conn.prepareStatement("INSERT INTO jailx_address(jailx_id,street,city,state,zip) VALUES(?,?,?,?,?)");
			
			//Jailx - Charge
			insert_jailx_charge = conn.prepareStatement("INSERT INTO jailx_charge(jailx_id_1,arresting_agency,grade_of_charge,charge_description,disposition) VALUES(?,?,?,?,?)");
			
			//Booking
			insert_booking = conn.prepareStatement("INSERT INTO booking(mid_number,firstname,lastname,year_of_birth,race,sex) VALUES(?,?,?,?,?,?)");
			select_id_from_booking_where_mid_number = conn.prepareStatement("SELECT id FROM booking WHERE mid_number=?");
			
			//Booking - Address
			insert_booking_address = conn.prepareStatement("INSERT INTO booking_address(booking_id,street,city,state,zip) VALUES(?,?,?,?,?)");
			
			//Booking - Charge
			insert_booking_charge = conn.prepareStatement("INSERT INTO booking_charge(booking_idx,booking_date,released_date,arresting_agency,grade_of_charge,charge_description,court_jurisdiction,bonding_company,bond_amount,warrant_number,police_case_number,last_update) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			select_id_from_booking_charge_where_booking_idx_and_booking_date_and_charge_description = conn.prepareStatement("SELECT id FROM booking_charge where booking_idx=? AND booking_date=? AND charge_description=?");
			update_booking_charge_where_id = conn.prepareStatement("UPDATE booking_charge SET booking_date=?,released_date=?,arresting_agency=?,grade_of_charge=?,charge_description=?,court_jurisdiction=?,bonding_company=?,bond_amount=?,warrant_number=?,police_case_number=?,last_update=? WHERE id=?");
			select_boocking_charge_where_grade_of_charge = conn.prepareStatement("SELECT * FROM booking_charge WHERE grade_of_charge=?");
			update_booking_charge_where_id_grade_of_charge = conn.prepareStatement("UPDATE booking_charge SET grade_of_charge=? WHERE id=?");
			
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
			System.out.println("<MySQL " + uuid.toString().substring(0, 8) + " Disconnected>");
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
