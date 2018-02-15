package ast;

import java.io.*;
import static applicationStructure.Constants.*;

/**
 * @author team-22
 * ReadFile class. It coverts the given java program to a string. 
 * The string size is big enough to handle most java programs. 
 * A future validation will also check for the size of the files to be below a certain limit(in MB)
 */
public class ReadFile {

	
	//default empty constructor
	public ReadFile(){
		
	}
	
	public String readFileToString(String filePath) throws IOException {
		StringBuilder fileData = new StringBuilder(BUILDER_SIZE_CAPACITY);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[SMALL_BUF_SIZE];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[BUF_SIZE];
		}
 
		reader.close();

		return  fileData.toString();	
	}

}
