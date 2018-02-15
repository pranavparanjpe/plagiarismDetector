package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;

/**
 * 
 * @author Team-22 The FieldDeclaration visitor to get the various fields
 *         declared
 */
public class FieldDeclarationVisitor extends ASTVisitor {
	// Stores the Field variables declared in the program
	private HashMap<String, List<Integer>> varMap = null;

	public FieldDeclarationVisitor() {
		varMap = new HashMap<String, List<Integer>>();
	}

	/**
	 * Get the variables declared in the code
	 */
	@Override
	public boolean visit(FieldDeclaration node) {


		addToHashMap(node.getType().toString(), node.fragments().get(0).toString().split("=")[0]);

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
	 * Getter for the hashmap
	 * 
	 * @return
	 */
	public HashMap<String, List<Integer>> getVarMap() {
		return varMap;
	}

	/**
	 * Transfer the string of a node to a hash value
	 * 
	 * @param A input string
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
}
