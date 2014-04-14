package dm.uga.parser;

/**
 * Opens file and returns data
 * 
 * @author Vincent Lee
 * @since April 7, 2014
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.FileReader;

public class FileStream {
	private String line;
	private BufferedReader reader;
	
	public FileStream() {}
	
	/**
	 * Opens file stream
	 * @param filename
	 * @return if file can be opened
	 */
	public boolean openFile(String filename) {
		try {
			reader = new BufferedReader(new FileReader(filename));
			return true;
		} catch (Exception e) {
			System.out.println("error: openFile");
		}
		return false;
	}
	
	/**
	 * Checks if there is next line in route file
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
