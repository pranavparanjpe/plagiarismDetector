package ast;

import org.eclipse.jdt.core.dom.MethodDeclaration;

/**
 * A Method of the java files which are parsed. This is a type of ASTNode
 * @author team-22
 */
public class MethodNode {

	// a method declaration of this method node
	public MethodDeclaration methodNode = null;
	// a list of nodes under this method node


	/**
	 *  initialization of this class
	 */
	public MethodNode() {
		this.methodNode = null;
	}

}
