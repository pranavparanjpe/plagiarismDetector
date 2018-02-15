package ast;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;

/**
 * A visitor which visits the methods of the java files which are parsed. 
 * This is a type of ASTNode
 * @author team-22
 */
public class MethodNodeVisitor extends ASTVisitor {

	// a list of methodNodes of this visitor
	List<MethodDeclaration> methodNodeList = new ArrayList<>();

	/**
	 * getter function of the parameter of MethodNodeList
	 * @return the list of methodNode of this visitor
	 */
	public List<MethodDeclaration> getMethodDecs() {
		return methodNodeList;
	}

	/**
	 * visit function to accept this visitor
	 */
	@Override
	public boolean visit(MethodDeclaration node) {
		methodNodeList.add(node);
		return true;
	}

}
