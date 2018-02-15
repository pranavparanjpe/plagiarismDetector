package ast;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;

/**
 *NodeVisitor class which extends the ASTVisitor. It stores a list of nodes from
 *the AST generated.
 *@author team-22
 */
public class NodeVisitor extends ASTVisitor {

	// a list of ASTNode of this visitor
	public List<ASTNode> nodeList = new ArrayList<ASTNode>();

	/**
	 * previsit for LCS algorithm which requires a preorder traversal
	 */
	@Override
	public void preVisit(ASTNode node) {
		nodeList.add(node);
	}

	/**
	 * getter function of the nodeList under this ASTVisitor
	 * @return the nodeList of this visitor
	 */
	public List<ASTNode> getASTNodes() {
		return nodeList;
	}
}