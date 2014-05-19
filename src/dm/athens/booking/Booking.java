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

package dm.athens.booking;

import java.util.ArrayList;
import java.util.List;

/**
 * Jail Booking Recap Report
 * 
 * @author Vincent Lee
 * @since April 18, 2014
 * @version 2.0
 */

public class Booking {
	private int mid_number;
	private String firstname, lastname, year_of_birth, race, sex;
	
	private Booking_address address;
	private List<Booking_charge> charges;
	
	/**
	 * Constructor
	 * @param mid_number
	 * @param firstname
	 * @param lastname
	 * @param year_of_birth
	 * @param race
	 * @param sex
	 */
	public Booking(int mid_number, String firstname, String lastname, String year_of_birth, String race, String sex) {
		this.mid_number = mid_number;
		this.firstname = firstname;
		this.lastname = lastname;
		this.year_of_birth = year_of_birth;
		this.race = race;
		this.sex = sex;
		this.charges = new ArrayList<Booking_charge>();
	}
	
	
	/** @param address the address to set */
	public void setAddress(Booking_address address) {
		this.address = address;
	}
	/** @param charge the charges to add */
	public void addCharge(Booking_charge charge) {
		this.charges.add(charge);
	}
	
	
	/** @return the address */
	public Booking_address getAddress() {return address;}
	
	/** @return the charges */
	public List<Booking_charge> getCharges() {return charges;}
	
	/** @return the mid_number */
	public int getMid_number() {return mid_number;}
	
	/** @return the firstname */
	public String getFirstname() {return firstname;}
	
	/** @return the lastname */
	public String getLastname() {return lastname;}
	
	/** @return the year_of_birth */
	public String getYear_of_birth() {return year_of_birth;}
	
	/** @return the race */
	public String getRace() {return race;}
	
	/** @return the sex */
	public String getSex() {return sex;}
}