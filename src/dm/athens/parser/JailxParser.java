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

/**
 * Parses Current Prisoner List with additional information
 * CURRENT PRISONER LISTING-DISPLAYS FIRST CHARGE ONLY
 * 
 * @author Vincent Lee
 * @since April 14, 2014
 * @version 1.0
 */

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dm.athens.jail.Jail;
import dm.athens.jail.Jailx;
import dm.athens.jail.Jailx_address;
import dm.athens.jail.Jailx_charge;

public class JailxParser extends JailParser {
	private final String detailsFront = "http://api.athensclarkecounty.com/sheriff/jail/details.asp?id=";
	private final String detailsEnd = "&pg=1";
	private List<Jailx> jailxList;
	private Document docc;
	private static final String folderPath = "images";
	private static boolean getPhoto;
	
	public JailxParser() {
		super();
		this.jailxList = new ArrayList<Jailx>();
	}
	
	public boolean openPopup(int mid_number) {
		try {
			docc = Jsoup.connect(detailsFront + mid_number + detailsEnd).get();
			return true;
		} catch (Exception e) {
			System.out.println("error: openPopup(" + mid_number + ")");
			return false;
		}
	}
	
	public Jailx_address parseAddress(String address) {
		try {
			List<String> tokens = new ArrayList<String>();
			
			Scanner tokenize = new Scanner(address);
			tokenize.useDelimiter("\u00a0");
			while (tokenize.hasNext())
			    tokens.add(tokenize.next());
			tokenize.close();
			
			String street = tokens.get(0);
			String city = tokens.get(2);
			city = city.substring(0, city.length()-1); //remove "," from end
			String state = tokens.get(3);
			if (state.length() == 0)
				state = null;
			
			
			String zip = null;
			if (tokens.size() == 6)
				zip = tokens.get(5);
			
			//Zip
			//Replace all numbers: [^a-zA-Z]
			//Replace all letters: [a-zA-Z]
			zip = zip.replaceAll("[a-zA-Z]", "");
			if (zip.length() != 5) {
				zip = null;
				System.out.println("error: zip-" + zip);
			}
			
			
			if (DEBUG) {
				System.out.println("street-" + street);
				System.out.println("city-" + city);
				System.out.println("state-" + state);
				System.out.println("zip-" + zip);
			}
			
			return new Jailx_address(street, city, state, zip);
		} catch (Exception e) {
			System.out.println("error: address");
			return null;
		}
		
	}
	
    private void getImage(String src, int mid_number) {
    	try {
    		String filename = mid_number + ".jpeg";
    		
    		//Open a URL Stream
            URL url = new URL(src);
            InputStream in = url.openStream();
            
            OutputStream out = new BufferedOutputStream(new FileOutputStream(folderPath + System.getProperty("file.separator") + filename));
            
            int i;
            while ((i = in.read()) != -1)
            	out.write(i);
            
            out.close();
            in.close();
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
	
	public void parseAdditional() {
		for (Jail instance : jailList) {
			System.out.println(instance.getMid_number());
			
			Jailx_address address = null;
			List<Jailx_charge> charges = new ArrayList<Jailx_charge>();
			Date released_date = null;
			int height = 0;
			int weight = 0;
			boolean photo  = false;
			
			//Load the pop-up
			openPopup(instance.getMid_number());
			
			//Get the table
			Elements table = docc.select("tr");
			
			//Table Rows
			int counter = 0;
			for (Element row : table) {
				//Table Columns
				Elements column = row.select("td");
				
				//Address
				if (counter == 1)
					address = parseAddress(column.get(1).text());
				
				//Height & Weight
				if (counter == 3) {
					try {
						String tmp = column.get(3).text();
						int firstSlash = tmp.indexOf("/"); //Split on "/"
						
						//Height
						String heightStr = tmp.substring(0, firstSlash).trim(); //First chunck
						List<String> tokens = new ArrayList<String>();
						
						Scanner tokenize = new Scanner(heightStr);
						tokenize.useDelimiter("'"); //use ' as token
						while (tokenize.hasNext())
						    tokens.add(tokenize.next());
						tokenize.close();
						
						int feet = Integer.parseInt(tokens.get(0));
						int inches = Integer.parseInt(tokens.get(1).substring(0, tokens.get(1).length()-1));
						
						//Calculate height
						height = feet * 12 + inches;
						
						//Weight
						String weightStr = tmp.substring(firstSlash+1).trim(); //Second chunck
						weightStr = weightStr.substring(0, weightStr.indexOf(" ")); //Remove "lbs."
						weight = Integer.parseInt(weightStr);
						
						if (DEBUG) {
							System.out.println(height);
							System.out.println(weight);
						}
					} catch (Exception e) {
						System.out.println("error: Height & Weight");
					}
				}
				
				//Booking Date & Release Date
				if (counter == 4) {
					if (column.get(3).text().equalsIgnoreCase("Currently Incarcerated"))
						released_date = null;
					else {
						try {
							SimpleDateFormat releaseFormat = new SimpleDateFormat("MM/dd/yyyyhh:mm aa"); // 3/10/20141:15 P.M.
							String date = column.get(3).text().replace("\u00a0",""); //remove "&nbsp;"
							date = date.replace(".", ""); //Fix "P.M." -> "PM"
							released_date = releaseFormat.parse(date);
						} catch (ParseException e) {
							System.out.println("error: Release Date");
						}
					}
				}
				
				//Image
				if (counter == 5) {
					//Get Image Tag
					Elements image = column.select("img");
					
					//Get image source url
					String imageURL = image.get(0).absUrl("src");
					
					//http://api.athensclarkecounty.com/sheriff/jail/notavailable.gif
					if (!imageURL.endsWith("notavailable.gif")) {
						if (getPhoto) getImage(imageURL, instance.getMid_number());
						photo = true;
					}
				}
				
				//Charges
				if (counter >= 8) {
					String arresting_agency = column.get(0).text();
					String grade_of_charge = column.get(1).text();
					if (grade_of_charge.length() == 0) grade_of_charge = null;
					String charge_description = column.get(2).text();
					String disposition = column.get(3).text();
					
					charges.add(new Jailx_charge(arresting_agency, grade_of_charge, charge_description, disposition));
				}
				
				counter++;
			}
			
			//Convert Jail Object to Jailx Object
			Jailx object = new Jailx(instance.getMid_number(), instance.getFirstname(), instance.getLastname(), 
					instance.getSex(), instance.getRace(), instance.getYear_of_birth(), height, weight, 
					instance.getBooking_date(), released_date, instance.getBond_amount(), instance.getCase_number(), 
					instance.getPolice_case_number(), instance.getVisitation(), photo);
			object.addAllCharges(charges);
			object.setAddress(address);
			jailxList.add(object);
		}
	}
	
	public void dataToSQL() {
		try {
			global.openDBconnection();
			
			for (Jailx instance : jailxList) {
				try {
					//Jailx
					global.insert_jailx.setInt(1, instance.getMid_number());
					global.insert_jailx.setString(2, instance.getFirstname());
					global.insert_jailx.setString(3, instance.getLastname());
					global.insert_jailx.setString(4, instance.getSex());
					global.insert_jailx.setString(5, instance.getRace());
					global.insert_jailx.setString(6, instance.getYear_of_birth());
					global.insert_jailx.setInt(7, instance.getHeight());
					global.insert_jailx.setInt(8, instance.getWeight());
					global.insert_jailx.setTimestamp(9, new Timestamp(instance.getBooking_date().getTime()));
					global.insert_jailx.setTimestamp(10, (instance.getReleased_date() == null) ? null : new Timestamp(instance.getReleased_date().getTime()));
					global.insert_jailx.setDouble(11, instance.getBond_amount());
					global.insert_jailx.setString(12, instance.getCase_number());
					global.insert_jailx.setString(13, instance.getPolice_case_number());
					global.insert_jailx.setString(14, instance.getVisitation());
					global.insert_jailx.setBoolean(15, instance.isPhoto());
					global.insert_jailx.setTimestamp(16, new Timestamp(lastUpdate.getTime()));
					global.insert_jailx.execute();
					
					int last_insert_id = 1;
					ResultSet rs = global.select_last_insert_id.executeQuery();
					if (rs.next()) last_insert_id = rs.getInt(1);
					
					//Jailx - Address
					Jailx_address address = instance.getAddress();
					if (address != null) {
						global.insert_jailx_address.setInt(1, last_insert_id);
						global.insert_jailx_address.setString(2, address.getStreet());
						global.insert_jailx_address.setString(3, address.getCity());
						global.insert_jailx_address.setString(4, address.getState());
						global.insert_jailx_address.setString(5, address.getZip());
						global.insert_jailx_address.execute();
					}
					
					//Jailx - Charges
					for (Jailx_charge charge : instance.getCharges()) {
						global.insert_jailx_charge.setInt(1, last_insert_id);
						global.insert_jailx_charge.setString(2, charge.getArresting_agency());
						global.insert_jailx_charge.setString(3, charge.getGrade_of_charge());
						global.insert_jailx_charge.setString(4, charge.getCharge_description());
						global.insert_jailx_charge.setString(5, charge.getDisposition());
						global.insert_jailx_charge.execute();
					}
				} catch (Exception e) {
					System.out.println(instance);
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			global.closeDBconnection();
		}
	}
	
	/**
	 * Main
	 * @param args filename, photo[off]
	 */
	public static void main(String[] args) {
		if (args.length == 2)
			getPhoto = true;
		
		JailxParser jailxParser = new JailxParser();
		jailxParser.openFile(args[0]);
		jailxParser.parseTable();
		jailxParser.parseAdditional();
		jailxParser.dataToSQL();
	}
}
