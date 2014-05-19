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
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
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

package dm.athens.jail;

/**
 * Jail - CURRENT PRISONER
 * 
 * @author Vincent Lee
 * @since April 14, 2014
 * @version 1.0
 */

import java.util.Date;

public class Jail {
	private int id, mid_number;
	private String firstname, lastname, sex, race, charge, case_number, police_case_number, year_of_birth, visitation;
	private double bond_amount;
	private Date booking_date;
	
	/**
	 * Constructor
	 * @param mid_number
	 * @param firstname
	 * @param lastname
	 * @param sex
	 * @param race
	 * @param booking_date
	 * @param charge
	 * @param bond_amount
	 * @param case_number
	 * @param police_case_number
	 * @param year_of_birth
	 * @param visitation
	 */
	public Jail(int mid_number, String firstname, String lastname, String sex, String race,
			Date booking_date, String charge, double bond_amount, String case_number,
			String police_case_number, String year_of_birth, String visitation) {
		this.mid_number = mid_number;
		this.firstname = firstname;
		this.lastname = lastname;
		this.sex = sex;
		this.race = race;
		this.booking_date = booking_date;
		this.charge = charge;
		this.bond_amount = bond_amount;
		this.case_number = case_number;
		this.police_case_number = police_case_number;
		this.year_of_birth = year_of_birth;
		this.visitation = visitation;
	}
	
	/**
	 * Constructor with SQL auto-increment id
	 * @param id
	 * @param mid_number
	 * @param firstname
	 * @param lastname
	 * @param sex
	 * @param race
	 * @param booking_date
	 * @param charge
	 * @param bond_amount
	 * @param case_number
	 * @param police_case_number
	 * @param year_of_birth
	 * @param visitation
	 */
	public Jail(int id, int mid_number, String firstname, String lastname, String sex, String race,
			Date booking_date, String charge, double bond_amount, String case_number,
			String police_case_number, String year_of_birth, String visitation) {
		this(mid_number, firstname, lastname, sex, race, booking_date, charge, bond_amount, case_number, police_case_number, year_of_birth, visitation);
		this.id = id;
	}
	
	/** @return the id */
	public int getId() {return id;}
	
	/** @return the mid_number */
	public int getMid_number() {return mid_number;}
	
	/** @return the firstname */
	public String getFirstname() {return firstname;}
	
	/** @return the lastname */
	public String getLastname() {return lastname;}
	
	/** @return the sex */
	public String getSex() {return sex;}
	
	/** @return the race */
	public String getRace() {return race;}
	
	/** @return the charge */
	public String getCharge() {return charge;}
	
	/** @return the case_number */
	public String getCase_number() {return case_number;}
	
	/** @return the police_case_number */
	public String getPolice_case_number() {return police_case_number;}
	
	/** @return the year_of_birth */
	public String getYear_of_birth() {return year_of_birth;}
	
	/** @return the visitation */
	public String getVisitation() {return visitation;}
	
	/** @return the bond_amount */
	public double getBond_amount() {return bond_amount;}
	
	/** @return the booking_date */
	public Date getBooking_date() {return booking_date;}
	
	/**
	 * @return toString
	 */
	public String toString() {
		return "Jail [id=" + id + ", mid_number=" + mid_number + ", firstname="
				+ firstname + ", lastname=" + lastname + ", sex=" + sex
				+ ", race=" + race + ", booking_date=" + booking_date
				+ ", charge=" + charge + ", bond_amount=" + bond_amount
				+ ", case_number=" + case_number + ", police_case_number="
				+ police_case_number + ", year_of_birth=" + year_of_birth
				+ ", visitation=" + visitation + "]";
	}
}