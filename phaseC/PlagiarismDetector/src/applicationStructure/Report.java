package applicationStructure;
/**
 * 
 * @author team-22
 * Class that contains the detailed plagiarism report
 * Report consists of : 
 * 	- Code Similarity Percentage
 * 	- Number of similar code lines
 * 	- Exact code snippet that contains possibly plagiarized code
 *
 */
public class Report {
	
	//Variable to store the percentage of similarity between two input codes
	private double similarityScore;
	
	//Variable that stores boolean result of code plagiarism
	private boolean isPlagiarised;
	
	//Variable that stores the percentage of similarity of comments in the input code
	private double commentSimilarity;
	
	//Variable that stores boolean result of comment plagiarism in the input code
	private boolean commentPlagiarised;
	
	//Variable that stores the final conclusion text, to be provided in the report, based on plagiarism tests
	private String finalResultText;
	
	/**
	 * 
	 * @return String that gives the final conclusion text to be printed in the report file
	 */
	public String getFinalResultText() {
		return finalResultText;
	}
	
	/**
	 * 
	 * @param finalResultText - conclusion text to be printed in the report
	 */
	public void setFinalResultText(String finalResultText) {
		this.finalResultText = finalResultText;
	}
	
	/**
	 * 
	 * @return True if comment plagiarism exists in input code
	 * 			False if comment plagiarism does not exists in input code
	 */
	public boolean isCommentPlagiarised() {
		return commentPlagiarised;
	}
	
	/**
	 * 
	 * @param commentPlagiarised - Boolean result of comment plagiarism check
	 */
	public void setCommentPlagiarised(boolean commentPlagiarised) {
		this.commentPlagiarised = commentPlagiarised;
	}
	
	/**
	 * 
	 * @return Percentage of comment similarity in input code
	 */
	public double getCommentSimilarity() {
		return commentSimilarity;
	}
	
	/**
	 * 
	 * @param commentSimilarity - Percentage of comment similarity in input code
	 */
	public void setCommentSimilarity(double commentSimilarity) {
		this.commentSimilarity = commentSimilarity;
	}
	
	/**
	 * 
	 * @return True if input files are plagiarised
	 * 		   False if input files are not plagiarised
	 */
	public boolean isPlagiarised() {
		return isPlagiarised;
	}
	
	/**
	 * 
	 * @param isPlagiarised - Boolean result of file plagiarism
	 */
	public void setPlagiarised(boolean isPlagiarised) {
		this.isPlagiarised = isPlagiarised;
	}
	
	/**
	 * 
	 * @return Percentage of code similarity in the input files
	 */
	
	public double getSimilarityScore() {
		return similarityScore;
	}
	
	/**
	 * 
	 * @param similarityScore - Percentage of code similarity in the input files
	 */
	public void setSimilarityScore(double similarityScore) {
		this.similarityScore = similarityScore;
	}
	
	
}
