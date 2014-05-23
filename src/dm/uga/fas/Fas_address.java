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

package dm.uga.fas;

/**
 * Faculty and Staff - Address
 * 
 * @author Vincent Lee
 * @since April 8, 2014
 * @version 1.0
 */

public class Fas_address {
	private int id;
	private String name, street_1, street_2, city, state, zip, zip_4, country;
	private Fas_phone phone;
	
	/**
	 * @param name
	 * @param street_1
	 * @param street_2
	 * @param city
	 * @param state
	 * @param zip
	 * @param zip_4
	 * @param country
	 */
	public Fas_address(String name, String street_1, String street_2,
			String city, String state, String zip, String zip_4, String country) {
		this.name = name;
		this.street_1 = street_1;
		this.street_2 = street_2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.zip_4 = zip_4;
		this.country = country;
	}
	
	/**
	 * @param id
	 * @param name
	 * @param street_1
	 * @param street_2
	 * @param city
	 * @param state
	 * @param zip
	 * @param zip_4
	 * @param country
	 */
	public Fas_address(int id, String name, String street_1, String street_2,
			String city, String state, String zip, String zip_4, String country) {
		this(name, street_1, street_2, city, state, zip, zip_4, country);
		this.id = id;
	}
	
	/** @param phone the phone to set */
	public void setPhone(Fas_phone phone) {this.phone = phone;}
	
	/** @return the phone */
	public Fas_phone getPhone() {return phone;}
	
	/** @return the id */
	public int getId() {return id;}
	
	/** @return the name */
	public String getName() {return name;}
	
	/** @return the street_1 */
	public String getStreet_1() {return street_1;}
	
	/** @return the street_2 */
	public String getStreet_2() {return street_2;}
	
	/** @return the city */
	public String getCity() {return city;}
	
	/** @return the state */
	public String getState() {return state;}
	
	/** @return the zip */
	public String getZip() {return zip;}
	
	/** @return the zip_4 */
	public String getZip_4() {return zip_4;}
	
	/** @return the country */
	public String getCountry() {return country;}
}
