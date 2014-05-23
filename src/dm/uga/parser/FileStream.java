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
