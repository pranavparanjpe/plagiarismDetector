package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

/**
 * 
 * @author Team-22 The VariableDeclarationVisitor class is used to visit and get
 *         the lit of all the variables declared in the program.
 *
 */
public class VariableDeclarationVisitor extends ASTVisitor {
	public VariableDeclarationVisitor() {
		varMap = new HashMap<String, List<Integer>>();
	}

	/**
	 * Get the variables declared in the code
	 */
	@Override
	public boolean visit(VariableDeclarationFragment node) {
		//If the visited node is of type FieldDeclaration
		if (node.getParent() instanceof FieldDeclaration) {

			FieldDeclaration declaration = ((FieldDeclaration) node.getParent());

			if (declaration.getType().isSimpleType()) {
				String typeSimpleName = declaration.getType().toString();

				addToHashMap(typeSimpleName, node.getName().toString());

			}
		}
		//The node is of VariableDeclarationStatement
		else if (node.getParent() instanceof VariableDeclarationStatement) {
			VariableDeclarationStatement var = ((VariableDeclarationStatement) node.getParent());

			addToHashMap(var.getType().toString(), node.getName().toString());

		}
		//The node is of VaraibleExpression
		else if (node.getParent() instanceof VariableDeclarationExpression) {
			VariableDeclarationExpression vardeclexpr = ((VariableDeclarationExpression) node.getParent());

			addToHashMap(vardeclexpr.getType().toString(), node.getName().toString());

		}
		return false; // do not continue

	}

	/**
	 * Add the Data type and name of the fields to a hashmap of values with key as
	 * data Type
	 * 
	 * @param string
	 * @param string2
	 */
	private void addToHashMap(String string, String string2) {
		if (varMap.containsKey(string)) {
			List<Integer> itemsList = varMap.get(string);

				// add if item is not already in list
				itemsList.add(hashCode(string2));
				varMap.put(string, itemsList);

		} else {
			List<Integer> itemsList = new ArrayList<Integer>();
			itemsList.add(hashCode(string2));
			varMap.put(string, itemsList);

		}

	}



	/**
	 * Get the Hashmap of variable and dataType
	 * 
	 * @return
	 */
	public HashMap<String, List<Integer>> getVarMap() {
		return varMap;
	}

	/**
	 * Transfer the string of a node to a hash value
	 * 
	 * @param A
	 *            input string
	 * @return a hash value of input string
	 */
	public int hashCode(String key) {
		// set a prime number as the factor of transformation
		int arraySize = 11113;
		int hashCode = 0;
		for (int i = 0; i < key.length(); i++) {
			int letterValue = key.charAt(i) - 96;
			hashCode = ((hashCode << 5) + letterValue) % arraySize;
		}
		return hashCode;
	}

	private HashMap<String, List<Integer>> varMap = null;

}
