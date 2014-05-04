package dm.uga.parser;

/**
 * Opens file and returns data
 * 
 * @author Vincent Lee
 * @since April 7, 2014
 * @version 1.0
 */

import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileStream {
	private String line;
	private BufferedReader scanner;
	
	public FileStream() {}
	
	/**
	 * Opens file stream
	 * @param filename
	 * @return if file can be opened
	 */
	public boolean openFile(String filename) {
		try {
//			scanner = new Scanner(new File(filename));
			scanner = new BufferedReader(new FileReader(filename));
			return true;
		} catch (Exception e) {
			System.out.println("error: openFile");
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
			if ((line = scanner.readLine()) != null)
				return true;
		} catch (Exception e) {
			System.out.println("error: next");
		}
		return false;
	}
	
	/**
	 * Returns next line in the file
	 * @return
	 */
	public String nextLine() {
		try {
			return line.trim();
		} catch (Exception e) {
			System.out.println("error: nextLine");
		}
		return null;
	}
}
