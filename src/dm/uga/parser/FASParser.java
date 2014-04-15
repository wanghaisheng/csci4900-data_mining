package dm.uga.parser;

/**
 * Parses file information
 * 
 * @author Vincent Lee
 * @since April 7, 2014
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dm.dao.GlobalDB;
import dm.uga.fas.Faculty_and_staff;

public class FASParser {
	FileStream fileStream;
	List<Faculty_and_staff> fas;
	String line;
	
	public FASParser(String filename) {
		fileStream = new FileStream();
		fileStream.openFile(filename);
		fas = new ArrayList<Faculty_and_staff>();
	}
	
	public String advance() {
		return (fileStream.next()) ? line = fileStream.nextLine() : null;
	}
	
	public void parse() {
		while (fileStream.next()) {
			line = fileStream.nextLine();
			
			//TODO: parse on ".." not email
			start:
			if (line.endsWith(",")) {
				//TODO: last name "ADAS FDFD" -> "Adas Fdfd"
				System.out.println("l-"+ line.substring(0, 1) + line.substring(1, line.length()-1).toLowerCase());
//				advance();
				ArrayList<String> tokens = new ArrayList<String>();		
				Scanner tokenize = new Scanner(advance());
				while (tokenize.hasNext())
				    tokens.add(tokenize.next());
				tokenize.close();
//				System.out.println(tokens);
				
				if (tokens.get(tokens.size()-1).length() == 1)
					System.out.println("m-" + tokens.remove(tokens.size()-1));
				
				String firstname = "";
				for (String str : tokens)
					firstname += str + " ";
				firstname = firstname.trim();
				
				System.out.println("f-" + firstname);
				
//				System.out.println(line);
//				return;
//				System.out.println(advance());
				
				advance();
				if (line.contains("..")) {
					System.out.println("p-" + advance());
					System.out.println("t-" + advance());
				} else {
					System.out.println("t-" + line);
				}
					
				
				
				advance();
				do {
					
					if (line.contains(","))
						break start;
					
					System.out.println(line);
					
					advance();
				} while (!line.contains("@"));
				
				System.out.println("e-" + line);
				
//				return;
			} else {
//				System.out.println(line);
			}
			
//			System.out.println(line);
			
		}
	}
	
	/**
	 * @return the fas
	 */
	public List<Faculty_and_staff> getFAS() {
		return fas;
	}

	/**
	 * @param fas the fas to set
	 */
	public void setFas(List<Faculty_and_staff> fas) {
		this.fas = fas;
	}

	public static void main(String[] args) {
		new FASParser("45").parse();
		GlobalDB global = new GlobalDB();
//		global.openDBconnection();
//		System.out.println("fas");
//		new faculty_and_staff("", "", "", "");
	}
}
