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

package dm.athens.parser;

/**
 * Opens CSV file and returns data
 * 
 * @author Vincent Lee
 * @since April 18, 2014
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dm.athens.booking.BookingCSV;

public class CSVStream {
	private String line;
	private BufferedReader reader;
	
	/**
	 * Opens file stream
	 * @param filename
	 * @return if file can be opened
	 */
	public boolean openCVSFile(String filename) {
		try {
			reader = new BufferedReader(new FileReader(filename));
			return true;
		} catch (Exception e) {
			System.out.println("error: openCVSFile");
		}
		return false;
	}
	
	/**
	 * Checks if there is next line
	 * @return if line in file is not blank
	 */
	public boolean next() {
		try {
			//if has next line exists, read line
			if ((line = reader.readLine()) != null)
				return true;
		} catch (Exception e) {
			System.out.println("error: next");
		}
		return false;
	}
	
	/**
	 * Returns next line in strut BookingCSV
	 * @return BookingCSV
	 */
	public BookingCSV nextBooking() {
		try {
			List<String> tokens = new ArrayList<String>();
					
			Scanner tokenize = new Scanner(line.trim());
			tokenize.useDelimiter(",");
			while (tokenize.hasNext())
			    tokens.add(tokenize.next());
			tokenize.close();
			
			//Get two dates
			String booking_date_str = tokens.get(1);
			String release_date_str = tokens.get(8);
			
			//Fix dates
			//2/07/2014 1:47 A.M
			//2/06/2014 6:24 P.M.
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
			booking_date_str = booking_date_str.replace(".", ""); //Fix "P.M." -> "PM"
			release_date_str = release_date_str.replace(".", "");
			
			Date booking_date = format.parse(booking_date_str);
			Date release_date = null;
			if (!release_date_str.equalsIgnoreCase("null")) 
				release_date = format.parse(release_date_str);
			
			//Dollar amount
			String bond = tokens.get(13).substring(1).replace(",", ""); //remove $ and ","
			double bond_amount = Double.parseDouble(bond);
			
			//Grade of Charge
			String grade_of_charge = tokens.get(10);
			if (grade_of_charge.equalsIgnoreCase("M"))
				grade_of_charge = "MISDEMEANOR";
			else if (grade_of_charge.equalsIgnoreCase("F"))
				grade_of_charge = "FELONY";
			else if (grade_of_charge.equalsIgnoreCase("B"))
				grade_of_charge = "TO BE DETERMINED";
			else if (grade_of_charge.equalsIgnoreCase("null"))
				grade_of_charge = null;
			
			
			//If user does not have a MID
			if (tokens.get(0).equalsIgnoreCase("null"))
				return null;
			
			//Set all "NULL" to proper null
			for (int i = 0; i < tokens.size(); i++) {
				if (tokens.get(i).equalsIgnoreCase("null"))
					tokens.set(i, null);
			}
			
			String year_of_birth = tokens.get(4);
			year_of_birth = year_of_birth.replaceAll("[a-zA-Z]", "");
			
			return new BookingCSV(Integer.parseInt(tokens.get(0)), booking_date, tokens.get(3), tokens.get(2), year_of_birth, 
					tokens.get(5), tokens.get(6), tokens.get(7), release_date, tokens.get(9), grade_of_charge, tokens.get(11), 
					tokens.get(12), bond_amount, tokens.get(14), tokens.get(15));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error: nextBooking");
		}
		return null;
	}
}
