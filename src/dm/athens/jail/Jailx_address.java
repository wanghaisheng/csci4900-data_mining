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

package dm.athens.jail;

/**
 * Jail Extended - Address
 * 
 * @author Vincent Lee
 * @since April 14, 2014
 * @version 1.0
 */

public class Jailx_address {
	private int id;
	private String street, city, state, zip;
	
	/**
	 * Constructor
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 */
	public Jailx_address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	/**
	 * Constructor with SQL auto-increment id
	 * @param id
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 */
	public Jailx_address(int id, String street, String city, String state, String zip) {
		this(street, city, state, zip);
		this.id = id;
	}
	
	/** @return the id */
	public int getId() {return id;}
	
	/** @return the street */
	public String getStreet() {return street;}
	
	/** @return the city */
	public String getCity() {return city;}
	
	/** @return the state */
	public String getState() {return state;}
	
	/** @return the zip */
	public String getZip() {return zip;}
	
	/**
	 * @return toString
	 */
	public String toString() {
		return "Jailx_address [id=" + id + ", street=" + street + ", city="
				+ city + ", state=" + state + ", zip=" + zip + "]";
	}
}
