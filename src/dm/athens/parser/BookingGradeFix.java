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

package dm.athens.parser;

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
			
			while (rs.next()) {
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
