package project;

/*	Class to represent the a specialized type of input operation
 * 	Compare the given input of files for plagiarism detection
 */
public class CompareOp extends InputOperation{
	
	public CompareOp(FileInput file1, FileInput file2){
		this.file1 = file1;
		this.file2 = file2;
	}
	
	@Override
	public void executeOperation() {
		
	}
	
	//parameters for the two file inputs to be compared
	FileInput file1;
	FileInput file2;
}
