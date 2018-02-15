package applicationStructure;

import java.util.*;

import org.eclipse.jdt.core.dom.*;

import ast.ASTparser;
/**
 * Concrete class that implements Plagiarism Detector Interface
 * Consist implementation to detect plagiarism in Java Code inputs
 * @author team-22
 */
public class JavaPlagiarismDetector implements PlagiarismDetector {
	
	@Override
	public Report getPlagiarismReport(String filePath1, String filePath2) {
		
		//Creating an algorithm factory
		AlgorithmFactory f = AlgorithmFactory.instance();
		AlgorithmCreator c = new AlgorithmCreator();
		
		//Creating objects of different algorithms to check plagiarism
		DetectionAlgorithm editDist = c.create(f, AlgorithmType.EditDistance);
		DetectionAlgorithm hashing =  c.create(f, AlgorithmType.Hashing);
				
		//Generate ASTs for the first file/directory path		
		ASTparser parser = new ASTparser();
		List<CompilationUnit> ast1 = parser.createListOfAST(filePath1);
		//Generate map of ASTs and its content
		Map<CompilationUnit,String> astToContentMap1 = parser.getAstToFileContentMap();
		
		//Re-initializing the parser to store values of second file path
		parser.setAstToFileContentMap(new HashMap<CompilationUnit, String>());
		parser.setFileContent("");
		
		//Generate ASTs for the second file/directory path
		List<CompilationUnit> ast2 = parser.createListOfAST(filePath2);
		//Generate map of ASTs and its content
		Map<CompilationUnit,String> astToContentMap2 = parser.getAstToFileContentMap();
				
		//Compare the two AST using edit distance/hashing algorithm and get plagiarism results
		Report editDistanceReport = editDist.compareAST(ast1, ast2);
		Report hashingReport = hashing.compareAST(ast1, ast2);
		
		//Set the code similarity of two targets as the greater of the scores between edit distance and hashing
		Report result = editDistanceReport.getSimilarityScore()>hashingReport.getSimilarityScore()? editDistanceReport:hashingReport;
		result.setPlagiarised(result.getSimilarityScore()>=Constants.PLAGIARISM_THRESHOLD);
		result.setFinalResultText(result.getSimilarityScore()>=Constants.PLAGIARISM_THRESHOLD?	Constants.REPORT_TEXT_FILES_PLAGIARISED:Constants.REPORT_TEXT_FILES_NOT_PLAGIARISED);;
		
		//Getting the comment similarity
		CommentSimilarity cs = new CommentSimilarity();
		double commentScore = cs.getCommentSimilarity(astToContentMap1,astToContentMap2);
		result.setCommentSimilarity(commentScore);
		result.setCommentPlagiarised(commentScore>=Constants.COMMENT_PLAGIARISM_THRESHOLD);
		
		return result;	

	}	

}
