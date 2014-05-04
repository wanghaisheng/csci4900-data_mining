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
import java.util.Stack;

import dm.dao.GlobalDB;
import dm.uga.fas.Faculty_and_staff;

public class FASParser {
	FileStream fileStream;
	String line;
	GlobalDB global;
	
	public FASParser(String filename) {
		fileStream = new FileStream();
		fileStream.openFile(filename);
		global = new GlobalDB();
	}
	
	public void parse() {
		global.openDBconnection();
		
		Stack<String> stack = new Stack<String>();
		String line = "";
		
		while (fileStream.next()) {
			line = fileStream.nextLine();
			
			if (line.startsWith(".")) {
				String firstname = stack.pop();
				String lastname = stack.pop();
				String extra = "";
				if (!lastname.contains(","))
					extra = stack.pop();
				
				
				if (!extra.equals("")) {
					//firstname
					String temp = lastname.trim() + " " + firstname.trim();
					firstname = temp;
					
					//lastname
					lastname = extra;
				}
				
				//all lastname
				lastname = lastname.replaceAll(",", "");
				lastname = lastname.trim();
				
				//clear the stack
				stack.clear();
				
				//commit to sql
				toSQL(firstname, lastname);
			} else
				stack.push(line);
		}
		
		global.closeDBconnection();
	}
	
	public void toSQL(String firstname, String lastname) {
		try {
			global.insert_student_listings.setString(1, firstname);
			global.insert_student_listings.setString(2, lastname);
			global.insert_student_listings.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new FASParser("sl_merged").parse();
	}
}
