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

package dm.uga.fas;

/**
 * Faculty and Staff - Phone Number
 * 
 * @author Vincent Lee
 * @since April 8, 2014
 * @version 1.0
 */

public class Fas_phone {
	private int id;
	private String country_code, area_code, exchange_code, line_number, extension;
	
	/**
	 * @param country_code
	 * @param area_code
	 * @param exchange_code
	 * @param line_number
	 * @param extension
	 */
	public Fas_phone(String country_code, String area_code,
			String exchange_code, String line_number, String extension) {
		this.country_code = country_code;
		this.area_code = area_code;
		this.exchange_code = exchange_code;
		this.line_number = line_number;
		this.extension = extension;
	}
	
	/**
	 * @param id
	 * @param country_code
	 * @param area_code
	 * @param exchange_code
	 * @param line_number
	 * @param extension
	 */
	public Fas_phone(int id, String country_code, String area_code,
			String exchange_code, String line_number, String extension) {
		this(country_code, area_code, exchange_code, line_number, extension);
		this.id = id;
	}
	
	/** @return the id */
	public int getId() {return id;}
	
	/** @return the country_code */
	public String getCountry_code() {return country_code;}
	
	/** @return the area_code */
	public String getArea_code() {return area_code;}
	
	/** @return the exchange_code */
	public String getExchange_code() {return exchange_code;}
	
	/** @return the line_number */
	public String getLine_number() {return line_number;}
	
	/** @return the extension */
	public String getExtension() {return extension;}
}
