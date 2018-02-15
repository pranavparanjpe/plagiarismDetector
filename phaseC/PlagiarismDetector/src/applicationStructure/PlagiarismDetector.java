package applicationStructure;
/**
 * Interface to get started with the plagiarism detection and get the results
 */
public interface PlagiarismDetector {
	/**
	 * Method that takes file-path entered on the UI and
	 * Returns a detailed plagiarism report
	 */
	public Report getPlagiarismReport(String filePath1, String filePath2);
}
