package project;

/*
 * Class to represent the a specialized type of selection operation i.e upload
 * uploads the input files for comparison (plagiarism check)
 */
public class Upload extends SelectionOp{
	
	/*
	 * Constructor to set the files to be uploaded
	 */
	public Upload(FileInput[] files){
		this.filesToUpload = files;
	}
	
	@Override
	public void executeOperation() {	
		
	}
	
	//parameter to store the files to be uploaded for plagiarism detection
	private FileInput[] filesToUpload;
	
}
