package applicationStructure;
/**
 * @author - team-22
 * Class containing all the constants used throughout the application
 */
public class Constants {
	
	/**
	 * Threshold to decide if two files are plagiarized
	 */
	public static final double PLAGIARISM_THRESHOLD = 55.0;
	
	/**
	 * Weight of variable similarity contribute to the final score
	 */
	public static final double VARIABLE_SIMILARITY_WEIGHT = 2;

	
	/**
	 * Threshold to decide if two files' comment are plagiarized
	 */
	public static final double COMMENT_PLAGIARISM_THRESHOLD = 90.0;
	
	/**
	 * Final text to display in the report if the files are plagiarised
	 */
	public static final String REPORT_TEXT_FILES_PLAGIARISED = "The similarity score of the two files when tested with our algorithms is greater than 55%,"
																+ "thus we believe that the files are plagiarised.";

	/**
	 * Final text to display in the report if the files are not plagiarised
	 */
	public static final String REPORT_TEXT_FILES_NOT_PLAGIARISED = "The similarity score of the two files when tested with our algorithms is less than 55%,"
																+ "thus we believe that the files are not plagiarised";
	
	/**
	 * File/Directory paths of several inputs that will be
	 * provided for plagiarism check
	 */
	
	/**
	 * File path of an empty java class
	 */
	public static final String EMPTY_CLASS_FILE_PATH = "src/testCodeSamples/empty.java";

	
	/**
	 * File path of a simple java class
	 */
	public static final String SIMPLE_CLASS_FILE_PATH = "src/testCodeSamples/SimpleClass.java";
	
	/**
	 * File path of a java class slightly modified from the simple class above
	 */
	public static final String SIMILAR_SIMPLE_CLASS_FILE_PATH = "src/testCodeSamples/SimilarSimpleClass.java";
	
	/**
	 * File path of a java class after renaming method name from the similar simple class above
	 */
	public static final String RENAME_SIMILAR_SIMPLE_CLASS_FILE_PATH = "src/testCodeSamples/RenameSimpleClass.java";
	
	/**
	 * File path for a class containing for loop
	 */
	public static final String FOR_LOOP_FILE_PATH = "src/testCodeSamples/forLoop.java";
	
	/**
	 * File path for a class containing while loop
	 */
	public static final String WHILE_LOOP_FILE_PATH = "src/testCodeSamples/whileLoop.java";
	
	/**
	 * File path for a class containing Number between Solution
	 */
	public static final String NUMBERS_BETWEEN_FILE_PATH = "src/testCodeSamples/NumbersBetween.java";
	
	
	/**
	 * File path for a class containing Number between Solution with minor change
	 */
	public static final String NUMBERS_BETWEEN_CHANGE_FILE_PATH = "src/testCodeSamples/NumbersBetweenMinor.java";
	
	/**
	 * File path for a class containing a initialization of list of variables
	 */
	public static final String LIST_OF_INITIALIZATION_FILE_PATH = "src/testCodeSamples/listOfInit.java";
	
	/**
	 * File path for a class containing a similar initialization of list of variables
	 */
	public static final String LIST_OF_SIMI_INITIALIZATION_FILE_PATH = "src/testCodeSamples/listOfSimInit.java";


	/**
	 * File path for a Lucene class 
	 */
	public static final String LUCENE_FILE_PATH = "src/testCodeSamples/Lucene.java";

	/**
	 * File path for a similar Lucene class 
	 */
	public static final String LUCENE_SIMI_FILE_PATH = "src/testCodeSamples/LuceneSimi.java";

	/**
	 * File path for a class containing line and block comments
	 */
	public static final String COMMENTS_FILE_PATH = "src/testCodeSamples/Comments.java";
	
	/**
	 * =============================Readfile Constants==========================
	 * 
	 */
	
	/**
	 * Builder size max capacity
	 */
	public static int BUILDER_SIZE_CAPACITY=1000;
	
	/**
	 * Small buffer size max capacity
	 */
	public static int SMALL_BUF_SIZE=1024;
	
	/**
	 * Buffer size max capacity
	 */
	public static int BUF_SIZE=1024;
	/**
	 * =============================PlagiarismChecker-Data File paths==========================
	 * 
	 */
	
	/**
	 * File path for sample 1 folder in set01
	 */
	public static final String SET01_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set01/Sample1";
	
	/**
	 * File path for sample 2 folder in set01
	 */
	public static final String SET01_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set01/Sample2";
	
	/**
	 * File path for sample 1 folder in set02
	 */
	public static final String SET02_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set02/Sample1";
	
	/**
	 * File path for sample 2 folder in set02
	 */
	public static final String SET02_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set02/Sample2";
	
	/**
	 * File path for sample 1 folder in set03
	 */
	public static final String SET03_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set03/Sample1";
	
	/**
	 * File path for sample 2 folder in set03
	 */
	public static final String SET03_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set03/Sample2";
	
	/**
	 * File path for sample 1 folder in set04
	 */
	public static final String SET04_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set04/Sample1";
	
	/**
	 * File path for sample 2 folder in set04
	 */
	public static final String SET04_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set04/Sample2";
	
	/**
	 * File path for sample 1 folder in set05
	 */
	public static final String SET05_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set05/Sample1";
	
	/**
	 * File path for sample 2 folder in set05
	 */
	public static final String SET05_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set05/Sample2";
	
	/**
	 * File path for sample 1 folder in set06
	 */
	public static final String SET06_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set06/Sample1";
	
	/**
	 * File path for sample 2 folder in set06
	 */
	public static final String SET06_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set06/Sample2";
	
	/**
	 * File path for sample 1 folder in set07
	 */
	public static final String SET07_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set07/Sample1";
	
	/**
	 * File path for sample 2 folder in set07
	 */
	public static final String SET07_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set07/Sample2";
	
	/**
	 * File path for sample 1 folder in set08
	 */
	public static final String SET08_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set08/Sample1";
	
	/**
	 * File path for sample 2 folder in set08
	 */
	public static final String SET08_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set08/Sample2";
	
	/**
	 * File path for sample 1 folder in set09
	 */
	public static final String SET09_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set09/Sample1";
	
	/**
	 * File path for sample 2 folder in set09
	 */
	public static final String SET09_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set09/Sample2";
	
	/**
	 * File path for sample 1 folder in set11
	 */
	public static final String SET11_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set11/Sample1";
	
	/**
	 * File path for sample 1 folder in set11
	 */
	public static final String SET11_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set11/Sample2";
	
	/**
	 * File path for sample 1 folder in set12
	 */
	public static final String SET12_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set12/Sample1";
	
	/**
	 * File path for sample 2 folder in set12
	 */
	public static final String SET12_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set12/Sample2";
	
	/**
	 * File path for sample 1 folder in set13
	 */
	public static final String SET13_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set13/Sample1";
	
	/**
	 * File path for sample 2 folder in set13
	 */
	public static final String SET13_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set13/Sample2";
	
	/**
	 * File path for sample 1 folder in set14
	 */
	public static final String SET14_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set14/Sample1";
	
	/**
	 * File path for sample 2 folder in set14
	 */
	public static final String SET14_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set14/Sample2";
	
	/**
	 * File path for sample 1 folder in set15
	 */
	public static final String SET15_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set15/Sample1";
	
	/**
	 * File path for sample 2 folder in set15
	 */
	public static final String SET15_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set15/Sample2";
	
	/**
	 * File path for sample 1 folder in set16
	 */
	public static final String SET16_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set16/Sample1";
	
	/**
	 * File path for sample 2 folder in set16
	 */
	public static final String SET16_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set16/Sample2";
	
	/**
	 * File path for sample 1 folder in set17
	 */
	public static final String SET17_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set17/Sample1";
	
	/**
	 * File path for sample 2 folder in set17
	 */
	public static final String SET17_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set17/Sample2";
	
	/**
	 * File path for sample 1 folder in set18
	 */
	public static final String SET18_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set18/Sample1";
	
	/**
	 * File path for sample 2 folder in set18
	 */
	public static final String SET18_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set18/Sample2";
	
	/**
	 * File path for sample 1 folder in set19
	 */
	public static final String SET19_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set19/Sample1";
	
	/**
	 * File path for sample 2 folder in set19
	 */
	public static final String SET19_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set19/Sample2";
	
	/**
	 * File path for sample 1 folder in set20
	 */
	public static final String SET20_SAMPLE1_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set20/Sample1";
	
	/**
	 * File path for sample 2 folder in set20
	 */
	public static final String SET20_SAMPLE2_FILE_PATH = "src/testCodeSamples/PlagiarismChecker-Data/set20/Sample2";
	
	
	
}
