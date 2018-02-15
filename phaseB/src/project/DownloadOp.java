package project;
/*
 * Class that represents a specialized type of output operation
 * Downloads the results of a plagiarism test to users system
 */
public class DownloadOp extends OutputOperation {
	
	public DownloadOp(Report result){
		this.plagiarismResult = result;
	}
	
	@Override
	public void executeOperation() {
		
	}
	//parameter to store the plagiarism results
	private Report plagiarismResult;
	
}
