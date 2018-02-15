package ast;
import org.eclipse.jdt.core.dom.*;
import java.util.*;

/**
 *@author team-22
 * Class contains Visitor to visit all the comment nodes in the AST
 * visits the block comments and line comments
 *
 */
public class CommentVisitor extends ASTVisitor {
	
	/**
	 * Constructor to set the parameters of the comment visitor
	 * @param cu - The AST of the parsed java code
	 * @param code - The actual code that was parsed to form AST
	 */
	public CommentVisitor(CompilationUnit cu, String code){
		super();
		this.cu = cu;
		this.code = code;
		this.comments = new ArrayList<String>();
	}
	
	/**
	 * Visitor to visit the line comment nodes in AST
	 * @param node - The line comment node in the AST being visited
	 */
	public boolean visit(LineComment node) {
		int start = node.getStartPosition();
		int end = start + node.getLength();
		String comment = code.substring(start, end);
		comments.add(comment);
		return true;
	}
	
	/**
	 * Visitor to visit the block comment nodes AST
	 * @param node - The block comment node in the AST being visited
	 */	
	public boolean visit(BlockComment node) {
		int start = node.getStartPosition();
		int end = start + node.getLength();
		String comment = code.substring(start, end);
		comments.add(comment);
		return true;
	}
	
	/**
	 * 
	 * @return List of comments that were visited by the comment visitor
	 */
	public ArrayList<String> getComments() {
		return comments;
	}
	
	//Variable to store the source code
	private String code;
	
	//Variable to store the AST generated from the source code
	private CompilationUnit cu;
	
	//List of comments nodes that will be visited by the comment visitor
	private ArrayList<String> comments;
}
