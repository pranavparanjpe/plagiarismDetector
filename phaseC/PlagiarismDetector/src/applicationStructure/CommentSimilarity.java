package applicationStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.dom.Comment;
import org.eclipse.jdt.core.dom.CompilationUnit;

import ast.CommentVisitor;

/**
 * @author team-22
 * Class that contains a method to calculate the similarity of
 * line and block comments present in the code provided as input for
 * plagiarism detection
 *
 */
public class CommentSimilarity {

	/**
	 * 
	 * @param astToContentMap1 - HashMap containing mapping of AST to code present in input1
	 * @param astToContentMap2 - HashMap containing mapping of AST to code present in input2
	 * @return Percentage of similarity of comments in the two inputs provided
	 */
	public double getCommentSimilarity(Map<CompilationUnit,String> astToContentMap1, Map<CompilationUnit,String> astToContentMap2){
		
		//ArrayLists to store the comments visited in the two AST inputs
		ArrayList<String> commentsVisitedAST1 = new ArrayList<String>();
		ArrayList<String> commentsVisitedAST2 = new ArrayList<String>();

		//Visiting all the comments in the first file input, and creating the list of comments
		for(CompilationUnit ast : astToContentMap1.keySet()){
			
			//Creating a comment visitor for the first AST
			CommentVisitor cv = new CommentVisitor(ast,astToContentMap1.get(ast));
			for (Comment comment : (List<Comment>) ast.getCommentList()) {
				comment.accept(cv);
			}
			
			//Adding the comments visited in the first AST
			commentsVisitedAST1.addAll(cv.getComments());
		}

		//Visiting all the comments in the second file input, and creating the list of comments
		for(CompilationUnit ast : astToContentMap2.keySet()){
			
			//Creating a comment visitor for the second AST
			CommentVisitor cv = new CommentVisitor(ast,astToContentMap2.get(ast));
			
			for (Comment comment : (List<Comment>) ast.getCommentList()) {
				comment.accept(cv);
			}
			
			//Adding the comments visited in the second AST
			commentsVisitedAST2.addAll(cv.getComments());
		}

		//Using the LCS algorithm to get the comment similarity in two file inputs
		AlgorithmFactory af = AlgorithmFactory.instance();
		LCSAlgorithm lcs = af.createLCSAlgorithm();

		//Creating the comments string
		String comment1 =  commentsVisitedAST1.toString().replace("[", "").replace("]", "");
		String comment2 =  commentsVisitedAST2.toString().replace("[", "").replace("]", "");
		
		//Getting the Longest Common string between the comments in two file inputs
		float lcsLength = lcs.getLCSLength(comment1, comment2);
		
		//Returning the comment similarity
		return 100 * lcs.getNormalizedSimilarity(commentsVisitedAST1.toString(), commentsVisitedAST2.toString(), lcsLength);

	}
}
