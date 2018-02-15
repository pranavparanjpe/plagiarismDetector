package project;
/*
 * Class to represent the a specialized type of selection operation
 * Selects a file from previously saved files, for comparison (plagiarism check)
 */
public class ChooseExisting extends SelectionOp{
	
	/*
	 * Constructor to set the private variable
	 */
	public ChooseExisting(FileInput file){
		this.selectedFile = file;
	}
	
	@Override
	public void executeOperation() {	
		
	}
	
	//parameter to store the file selected from existing saved documents
	private FileInput selectedFile;
	
}