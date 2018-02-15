package tests;

import static org.junit.Assert.*;

import org.eclipse.jdt.core.dom.*;
import org.junit.BeforeClass;
import org.junit.Test;

import applicationStructure.Constants;
import ast.*;
import java.util.*;

/**
 * Class containing test for the comment visitor
 * @author team-22
 *
 */
public class CommentVisitorTests {
	
	private static ASTparser astParser;
	
	/**
	 * creating the AST generator object
	 */
	@BeforeClass
	public static void setUpASTer() {
		astParser = new ASTparser();
	}
	
	/**
	 * Test to visit line and block comments nodes in the AST
	 */
	@Test
	public void testLineAndBlockComments() {
		
		String filepath = Constants.COMMENTS_FILE_PATH;
		List<CompilationUnit> ast = astParser.createListOfAST(filepath);
		Map<CompilationUnit,String> astContentMap = astParser.getAstToFileContentMap();
		
		//List to store all the comments visited
		ArrayList<String> commentsVisited = new ArrayList<String>();
		
		for(CompilationUnit a : astContentMap.keySet()){

			//Creating a comment visitor for the first AST
			CommentVisitor cv = new CommentVisitor(a,astContentMap.get(a));
			for (Comment comment : (List<Comment>) a.getCommentList()) {
				comment.accept(cv);
			}
			commentsVisited.addAll(cv.getComments());
		}
		assertEquals(commentsVisited.size(),3);
	}

}
