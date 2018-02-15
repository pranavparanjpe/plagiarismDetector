package project;
/*
 * Class that represents a specialized type of output operation
 * Views the results of a plagiarism test on the UI 
 */
public class ViewOp extends OutputOperation{
	
	public ViewOp(Report result){
		this.resultToDisplay = result;
	}
	
	@Override
	public void executeOperation() {
		
	}
	
	//parameter to store the plagiarism results to be viewed
	private Report resultToDisplay;
}
