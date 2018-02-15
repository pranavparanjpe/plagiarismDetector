package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.BeforeClass;
import org.junit.Test;

import applicationStructure.*;
import ast.*;

/** 
 * @author team-22
 * Contains tests for LCSAlgorithm.java
 * Tests different methods used for the LCS algorithm
 */

public class LCSAlgorithmTests {
	private static ASTparser astParser;
	private static LCSAlgorithm lcs;
	
	/**
	 * creating the AST generator object
	 */
	@BeforeClass
	public static void setUpASTer() {
		astParser = new ASTparser();
	}

	
	/**
	 * creating the the algorithm factory and LCS algorithm object using the factory
	 */
	@BeforeClass
	public static void createLCSWithFactory() {
		lcs = new LCSAlgorithm();
	}
	
	/**
	 * testing the 'getlcsSize' method of LCS Algorithm
	 * test lcs length of two same files to be the size(total chars) of the files itself
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testGetLCSSize(){
		String filepath1 = Constants.SIMPLE_CLASS_FILE_PATH;
		String filepath2 = Constants.SIMPLE_CLASS_FILE_PATH;
		List<CompilationUnit> ast1 = astParser.createListOfAST(filepath1);
		List<CompilationUnit> ast2 = astParser.createListOfAST(filepath2);
		String ast1Str = lcs.getSingleString(ast1);
		String ast2Str = lcs.getSingleString(ast2);
		assertEquals(lcs.getLCSLength(ast1Str, ast2Str),ast1Str.toCharArray().length,1);
	}
	
	/**
	 * test to compare two ASTs with the same file as input
	 */
	@Test
	public void compareASTTest(){
		String filepath1 = Constants.SIMPLE_CLASS_FILE_PATH;
		String filepath2 = Constants.SIMPLE_CLASS_FILE_PATH;
		List<CompilationUnit> ast1 = astParser.createListOfAST(filepath1);
		List<CompilationUnit> ast2 = astParser.createListOfAST(filepath2);
		assertEquals(lcs.compareAST(ast1, ast2).getSimilarityScore(),100.00,1);
	}
	
	/**
	 * test to compare two ASTs with method names changed, but structure remains the same
	 */
	@Test
	public void compareSimilarAST(){
		String filepath1 = Constants.SIMPLE_CLASS_FILE_PATH;
		String filepath2 = Constants.SIMILAR_SIMPLE_CLASS_FILE_PATH;
		List<CompilationUnit> ast1 = astParser.createListOfAST(filepath1);
		List<CompilationUnit> ast2 = astParser.createListOfAST(filepath2);
		assertEquals(lcs.compareAST(ast1, ast2).getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	/**
	 * Test to compare two completely different file
	 */
	@Test
	public void compareDifferentASTs(){
		String filepath1 = Constants.SIMPLE_CLASS_FILE_PATH;
		String filepath2 = Constants.NUMBERS_BETWEEN_FILE_PATH;
		List<CompilationUnit> ast1 = astParser.createListOfAST(filepath1);
		List<CompilationUnit> ast2 = astParser.createListOfAST(filepath2);
		assertEquals(lcs.compareAST(ast1, ast2).getSimilarityScore() < Constants.PLAGIARISM_THRESHOLD,true);
	}
	
	/**
	 * Test to compare two sample files in Set01
	 */
	@Test
	public void compareSetO1(){
		String filepath1 = Constants.SET01_SAMPLE1_FILE_PATH;
		String filepath2 = Constants.SET01_SAMPLE2_FILE_PATH;
		List<CompilationUnit> ast1 = astParser.createListOfAST(filepath1);
		List<CompilationUnit> ast2 = astParser.createListOfAST(filepath2);
		assertEquals(lcs.compareAST(ast1, ast2).getSimilarityScore() > Constants.PLAGIARISM_THRESHOLD,true);
	}

}
