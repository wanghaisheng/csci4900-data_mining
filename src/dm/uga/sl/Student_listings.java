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

package dm.uga.sl;

/**
 * Student Listings
 * 
 * @author Vincent Lee
 * @since April 8, 2014
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class Student_listings {
	private int id;
	private String firstname, middlename, lastname, email, year_start, year_end;
	private List<Sl_phone> phone;
	private List<Sl_address> address;
	
	/**
	 * No-args Constructor
	 */
	public Student_listings() {
		phone = new ArrayList<Sl_phone>();
		address = new ArrayList<Sl_address>();
	}
	
	/**
	 * Constructor
	 * @param firstname
	 * @param middlename
	 * @param lastname
	 * @param email
	 * @param year_start
	 * @param year_end
	 */
	public Student_listings(String firstname, String middlename,
			String lastname, String email, String year_start, String year_end) {
		this();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.email = email;
		this.year_start = year_start;
		this.year_end = year_end;
	}
	
	/**
	 * Constructor with SQL auto-increment id
	 * @param id
	 * @param firstname
	 * @param middlename
	 * @param lastname
	 * @param email
	 * @param year_start
	 * @param year_end
	 */
	public Student_listings(int id, String firstname, String middlename,
			String lastname, String email, String year_start, String year_end) {
		this(firstname, middlename, lastname, email, year_start, year_end);
		this.id = id;
	}
	
	/**
	 * @param phone the phone to add
	 * @return true if this collection changed as a result of the call
	 */
	public boolean addPhone(Sl_phone phone) {
		return this.phone.add(phone);
	}
	
	/**
	 * @param address the address to add
	 * @return true if this collection changed as a result of the call
	 */
	public boolean addAddress(Sl_address address) {return this.address.add(address);}
	
	/** @return the phone */
	public List<Sl_phone> getPhone() {return phone;}
	
	/** @return the address */
	public List<Sl_address> getAddress() {return address;}
	
	/** @return the id */
	public int getId() {return id;}
	
	/** @return the firstname */
	public String getFirstname() {return firstname;}
	
	/** @return the middlename */
	public String getMiddlename() {return middlename;}
	
	/** @return the lastname */
	public String getLastname() {return lastname;}
	
	/** @return the email */
	public String getEmail() {return email;}
	
	/** @return the year_start */
	public String getYear_start() {return year_start;}
	
	/** @return the year_end */
	public String getYear_end() {return year_end;}
}
