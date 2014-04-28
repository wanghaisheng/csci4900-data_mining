package dm.athens.parser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dm.dao.GlobalDB;

public class BookingGradeFix {
	private GlobalDB global;
	
	public BookingGradeFix() {
		global = new GlobalDB();
	}
	
	public void MtoMISDEMEANOR() {
		try {
			global.openDBconnection();
			
			global.select_boocking_charge_where_grade_of_charge.setString(1, "M");
			
			ResultSet rs = global.select_boocking_charge_where_grade_of_charge.executeQuery();
			while (rs.next()) {
				global.update_booking_charge_where_id_grade_of_charge.setString(1, "MISDEMEANOR");
				global.update_booking_charge_where_id_grade_of_charge.setInt(2, rs.getInt("id"));
				global.update_booking_charge_where_id_grade_of_charge.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			global.closeDBconnection();
		}
	}
	
	public void FtoFELONY() {
		try {
			global.openDBconnection();
			
			global.select_boocking_charge_where_grade_of_charge.setString(1, "F");
			
			ResultSet rs = global.select_boocking_charge_where_grade_of_charge.executeQuery();
			
			int counter = 0;
			while (rs.next()) {
				counter++;
				global.update_booking_charge_where_id_grade_of_charge.setString(1, "FELONY");
				global.update_booking_charge_where_id_grade_of_charge.setInt(2, rs.getInt("id"));
				global.update_booking_charge_where_id_grade_of_charge.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			global.closeDBconnection();
		}
	}
	
	public static void main(String[] args) {
		BookingGradeFix booking = new BookingGradeFix();
		booking.MtoMISDEMEANOR();
		booking.FtoFELONY();
	}
}
