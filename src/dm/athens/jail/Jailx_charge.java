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
 * Jail Extended - Charge
 * 
 * @author Vincent Lee
 * @since April 14, 2014
 * @version 1.0
 */

public class Jailx_charge {
	private int id;
	private String arresting_agency, grade_of_charge, charge_description, disposition;
	
	/**
	 * Constructor
	 * @param arresting_agency
	 * @param grade_of_charge
	 * @param charge_description
	 * @param disposition
	 */
	public Jailx_charge(String arresting_agency, String grade_of_charge, String charge_description, String disposition) {
		this.arresting_agency = arresting_agency;
		this.charge_description = charge_description;
		this.disposition = disposition;
		this.grade_of_charge = grade_of_charge;
	}
	
	/**
	 * Constructor with SQL auto-increment id
	 * @param id
	 * @param arresting_agency
	 * @param grade_of_charge
	 * @param charge_description
	 * @param disposition
	 */
	public Jailx_charge(int id, String arresting_agency, String grade_of_charge, String charge_description, String disposition) {
		this(arresting_agency, grade_of_charge, charge_description, disposition);
		this.id = id;
	}
	
	/** @return the id */
	public int getId() {return id;}
	
	/** @return the arresting_agency */
	public String getArresting_agency() {return arresting_agency;}
	
	/** @return the grade_of_charge */
	public String getGrade_of_charge() {return grade_of_charge;}
	
	/** @return the charge_description */
	public String getCharge_description() {return charge_description;}
	
	/** @return the disposition */
	public String getDisposition() {return disposition;}
	
	/**
	 * @return toString
	 */
	public String toString() {
		return "Jailx_charge [id=" + id + ", arresting_agency="
				+ arresting_agency + ", grade_of_charge=" + grade_of_charge
				+ ", charge_description=" + charge_description
				+ ", disposition=" + disposition + "]";
	}
}