package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import applicationStructure.*;

/**
 * Contains tests for the concrete class that implements Plagiarism Detector Interface
 */
public class JavaPlagiarismDetectorTests {
	
	private static JavaPlagiarismDetector detector;
	
	//creating the JavaPlagiarismDetector
	@BeforeClass
	public static void createJavaDetector() {
		detector = new JavaPlagiarismDetector();
	}


	// test the set01 provided by instructors
	@Test
	public void Test1(){
		String filepath1 = Constants.SET01_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET01_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	// test the set02 provided by instructors
	@Test
	public void Test2(){
		String filepath1 = Constants.SET02_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET02_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	// test the set03 provided by instructors
	@Test
	public void Test3(){
		String filepath1 = Constants.SET03_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET03_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	// test the set04 provided by instructors
	@Test
	public void Test4(){
		String filepath1 = Constants.SET04_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET04_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	// test the set05 provided by instructors
	@Test
	public void Test5(){
		String filepath1 = Constants.SET05_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET05_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	// test the set06 provided by instructors
	@Test
	public void Test6(){
		String filepath1 = Constants.SET06_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET06_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	// test the set07 provided by instructors
	@Test
	public void Test7(){
		String filepath1 = Constants.SET07_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET07_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	// test the set08 provided by instructors
	@Test
	public void Test8(){
		String filepath1 = Constants.SET08_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET08_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	// test the set09 provided by instructors
	@Test
	public void Test9(){
		String filepath1 = Constants.SET09_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET09_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	// test the set11 provided by instructors
	@Test
	public void Test11(){
		String filepath1 = Constants.SET11_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET11_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	// test the set12 provided by instructors
	@Test
	public void Test12(){
		String filepath1 = Constants.SET12_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET12_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,false);
	}
	
	// test the set13 provided by instructors
	@Test
	public void Test13(){
		String filepath1 = Constants.SET13_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET13_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,false);
	}
	
	// test the set14 provided by instructors
	@Test
	public void Test14(){
		String filepath1 = Constants.SET14_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET14_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,false);
	}
	
	// test the set15 provided by instructors
	@Test
	public void Test15(){
		String filepath1 = Constants.SET15_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET15_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,false);
	}
	
	// test the set16 provided by instructors
	@Test
	public void Test16(){
		String filepath1 = Constants.SET16_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET16_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	// test the set17 provided by instructors
	@Test
	public void Test17(){
		String filepath1 = Constants.SET17_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET17_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	// test the set18 provided by instructors
	@Test
	public void Test18(){
		String filepath1 = Constants.SET18_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET18_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	// test the set19 provided by instructors
	@Test
	public void Test19(){
		String filepath1 = Constants.SET19_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET19_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	// test the set20 provided by instructors
	@Test
	public void Test20(){
		String filepath1 = Constants.SET20_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET20_SAMPLE2_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	

	//Test method compareAST
	@Test
	public void compareASTTest() throws IOException {
		String filepath1 = Constants.NUMBERS_BETWEEN_FILE_PATH;
		String filepath2 = Constants.NUMBERS_BETWEEN_CHANGE_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}

	//Test to compare two similar ASTs 1
	@Test
	public void compareSimTest() throws IOException {
		String filepath1 = Constants.NUMBERS_BETWEEN_FILE_PATH;
		String filepath2 = Constants.NUMBERS_BETWEEN_CHANGE_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	//Test to compare two different ASTs 
	@Test
	public void compareDifTest() throws IOException {
		String filepath1 = Constants.SIMPLE_CLASS_FILE_PATH;
		String filepath2 = Constants.NUMBERS_BETWEEN_CHANGE_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	
	//Test to compare two similar ASTs
	@Test
	public void compareSimiTest2() throws IOException{
		String filepath1 = Constants.SIMPLE_CLASS_FILE_PATH;
		String filepath2 = Constants.SIMILAR_SIMPLE_CLASS_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	//Test to compare two similar ASTs of implementing loops
	@Test
	public void compareASTLoopTest() throws IOException{
		String filepath1 = Constants.FOR_LOOP_FILE_PATH;
		String filepath2 = Constants.WHILE_LOOP_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
		
	//Test to compare two ASTs of similar initialization
	@Test
	public void compareASTInitTest() throws IOException{
		String filepath1 = Constants.LIST_OF_INITIALIZATION_FILE_PATH;
		String filepath2 = Constants.LIST_OF_SIMI_INITIALIZATION_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	//Test to compare one valid AST with one empty AST
	@Test
	public void emptyTest() throws IOException{
		String filepath1 = Constants.EMPTY_CLASS_FILE_PATH;
		String filepath2 = Constants.SIMPLE_CLASS_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath1, filepath2);
		assertEquals(r.getSimilarityScore() < Constants.PLAGIARISM_THRESHOLD,true);
		assertEquals(r.isPlagiarised(), false);
		assertEquals(r.isCommentPlagiarised(),false);
		assertEquals(r.getCommentSimilarity()==0.0,true);
		assertEquals(r.getFinalResultText(), "The similarity score of the two files"
				+ " when tested with our algorithms is less than 55%,thus we believe that the files are not plagiarised");
	}
	
	//Test to compare one valid AST with one empty AST
	@Test
	public void emptyTest2() throws IOException{
		String filepath1 = Constants.EMPTY_CLASS_FILE_PATH;
		String filepath2 = Constants.SIMPLE_CLASS_FILE_PATH;
		Report r = detector.getPlagiarismReport(filepath2, filepath1);
		assertEquals(r.getSimilarityScore() < Constants.PLAGIARISM_THRESHOLD,true);
		assertEquals(r.getFinalResultText(), "The similarity score of the two files"
				+ " when tested with our algorithms is less than 55%,thus we believe that the files are not plagiarised");
	}
		
}
