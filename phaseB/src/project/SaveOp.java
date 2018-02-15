package project;
/*
 * Class to represent the a specialized type of input operation
 * Saves an input file for future use
 */
public class SaveOp extends InputOperation {
	
	//Constructor to initialize the save operation
	public SaveOp(FileInput file){		
		this.fileToBeSaved = file;	
	}
	
	@Override
	public void executeOperation() {
		
	}
	
	//parameter to store the input file that has to be saved for future use
	FileInput fileToBeSaved;
}
