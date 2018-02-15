package applicationStructure;

import java.util.*;

import org.eclipse.jdt.core.dom.*;

import ast.*;


/**
 * Class of Plagiarism Detection by Hashing algorithm
 * @author team-22
 *
 */
public class HashingAlgorithm implements DetectionAlgorithm{
	

	/**
	 * compare two list of AST for plagiarism detection by Hashing Algorithm
	 * @param List of ASTs of files in input 1
	 * @param List of ASTs of files in input 2
	 * @return the similarity of two repository
	 */
	public Report compareAST(List<CompilationUnit> cu1, List<CompilationUnit> cu2) {
		
		// list of hash values of all single nodes without variable names for input 1
		List<Integer> hashList1 = generateSetFromDir(cu1);
		
		// set the flag to indicate repository 1 has been processed
		flag = false;
		
		// list of hash values of all single nodes without variable names for input 2
		List<Integer> hashList2 = generateSetFromDir(cu2);
		
		// initialize the retain and union set of two sets
		List<Integer> retain = new ArrayList<>();
		List<Integer> addAll = new ArrayList<>();
		
		// generate retain and union set of two sets
		generateRetainAndUnion(retain, addAll, hashList1, hashList2);
		// generate and set the final score
		Report report = new Report();
		double score = 100*(double)retain.size()/Math.min(hashList1.size(), hashList2.size())+Constants.VARIABLE_SIMILARITY_WEIGHT*compareDeclaredVariables();
		// if one of repository is without java file
		if(hashList1.size()!=hashList2.size() && Math.min(hashList1.size(), hashList2.size())==0)
			score = 0;
		report.setSimilarityScore(score>100? 100:score);
		return report;
	}
	
	/**
	 * generate a list of integer as hash values from the list of ASTs
	 * @param A list of ASTs
	 * @return A set of integer contains hashing value of nodes in this list of ASTs
	 */
	private List<Integer> generateSetFromDir(List<CompilationUnit> cu) {
		List<Integer> result = new ArrayList<>();
		for(CompilationUnit c:cu) {
			result.addAll(methodNodeParser(c));
		}
		return result;
	}
	
	/**
	 * traversal of the AST and add hash values of node into its corresponding list
	 * @param AST of the file
	 * @return a list of hash value of nodes in the AST of this file
	 */
	private List<Integer> methodNodeParser(CompilationUnit cu) {

		// AST methodNode visitor
		MethodNodeVisitor methodNodeVisitor = new MethodNodeVisitor();
		cu.accept(methodNodeVisitor);
		
		// variable visitor
		VariableDeclarationVisitor varVisitor=new VariableDeclarationVisitor();
		cu.accept(varVisitor);
		Map<String, List<Integer>> varMap=varVisitor.getVarMap();
		
		// Field variable visitor
		FieldDeclarationVisitor fieldVarVisitor=new FieldDeclarationVisitor();
		cu.accept(fieldVarVisitor);
		Map<String, List<Integer>> fieldVarMap =fieldVarVisitor.getVarMap();
		
		// get a union map from variable map and field variable map
		Map<String, List<Integer>> map = combineHashMaps(varMap,fieldVarMap);
		
		// generate finalMap of repositories accordingly
		if(flag)
			generateFinalMap(finalMap1, map);
		else
			generateFinalMap(finalMap2, map);	

				
		// list of leaf nodes with hash value
		List<Integer> leafNodes = createListOfLeafNodes(methodNodeVisitor);
		
		// remove the variable names from list of leaf nodes
		removeVariableNames(leafNodes, varMap.values());
		removeVariableNames(leafNodes, fieldVarMap.values());
		return leafNodes;
	}
	
	/**
	 * create the list of leaf nodes from the methodNodeVisitor
	 * @param methodNodeVisitor
	 * @return list of leaf nodes of a list of methods
	 */
	private List<Integer> createListOfLeafNodes(MethodNodeVisitor methodNodeVisitor) {
new ArrayList<>();

		//list of leaf nodes with hash value
		List<Integer> leafNodes = new ArrayList<>();
		
		// parse all methods to get hash values of each leaf node
		for(MethodDeclaration m:methodNodeVisitor.getMethodDecs()) {	
			MethodNode mNode = new MethodNode();
			mNode.methodNode = m;
			
			// get nodes under this methodNode via nodeVisitor
			NodeVisitor nv = new NodeVisitor();
			m.accept(nv);
			List<ASTNode> astnodes = nv.getASTNodes();
			
			// parse and get hash values of leaf nodes under this methodNode
			extractLeafNodes(leafNodes, astnodes, m);
		}
		return leafNodes;
	}

	/**
	 * add the list of nodes' hash value to the list of leaf nodes
	 * @param a list of leafNodes with hash values
	 * @param a list of leafNodes
	 * @param methodDeclaration as a methodNode
	 */
	private void extractLeafNodes(List<Integer> leafNodes, List<ASTNode> astnodes, MethodDeclaration m) {
		for (ASTNode node : astnodes) {
			
			// extract only leaf nodes
			if(isLeafNode(node))
				leafNodes.add(hashCode(node.toString()));
			
			// extract the operator
			if(node instanceof InfixExpression)
				leafNodes.add(hashCode(((InfixExpression) node).getOperator().toString()));	
			if(node instanceof PrefixExpression)
				leafNodes.add(hashCode(((PrefixExpression) node).getOperator().toString()));
			if(node instanceof PostfixExpression)
				leafNodes.add(hashCode(((PostfixExpression) node).getOperator().toString()));
			
			// extract the equal notation
			if(node instanceof VariableDeclarationFragment || node instanceof Assignment)
				leafNodes.add(hashCode("="));
			
			// exclude root node
			if (node.equals(m)) {
				continue;
			}

		}
		
	}

	/**
	 * remove variable names from the list of leaf nodes
	 * @param list of leaf Nodes
	 * @param lists of names of all types of variables
	 */
	private void removeVariableNames(List<Integer> leafNodes, Collection<List<Integer>> lists) {
		for(List<Integer> val:lists)
			leafNodes.removeAll(val);
	}
	
	/**
	 * add all variable nodes in this file into the final map accordingly
	 * @param finalMap with all variable nodes in all previous files
	 * @param map with all variable nodes in current file
	 */
	private void generateFinalMap(Map<String, List<Integer>> finalMap, Map<String, List<Integer>> map) {
		for(String key:map.keySet()) {
			List<Integer> list = finalMap.getOrDefault(key, new ArrayList<Integer>());
			list.addAll(map.get(key));
			finalMap.put(key, list);
		}
		
	}

	/**
	 * check if this node is a leaf node
	 * @param ASTNode
	 * @return A boolean value indicates whether this node is a leaf node
	 */
	private boolean isLeafNode(ASTNode node) {
		if(node instanceof Block || node instanceof Statement)
			return false;
		else
			return node.structuralPropertiesForType().size()==1 || node instanceof PrimitiveType;
	}
	
	/**
	 * Transfer the string of a node to a hash value
	 * @param A input string
	 * @return a hash value of input string
	 */
	private int hashCode(String key){  
		// set a prime number as the factor of transformation
	    int arraySize = 11113;      
	    int hashCode = 0;  
	    
	    // traversal the string and generate hash value accordingly
	    for(int i=0;i<key.length();i++){    
	        int letterValue = key.charAt(i) - 96; 
	        hashCode = ((hashCode << 5) + letterValue) % arraySize; 
	    }  
	    return hashCode;  
	} 
	
	/**
	 * generate the retain and union set of two sets
	 * @param set with retain elements
	 * @param set with retain elements
	 * @param set with elements from file 1
	 * @param set with elements from file 2
	 */	
	private void generateRetainAndUnion(List<Integer> retain, List<Integer> addAll, List<Integer> hashList1, List<Integer> hashList2) {
		List<Integer> commonList = new ArrayList<Integer>();
		List<Integer> temp = new ArrayList<Integer>();
		temp.addAll(hashList2);
        for(int num:hashList1) {
        	if(temp.contains(num))
        	{
        		commonList.add(num);
        		temp.remove(temp.indexOf(num));
        	}
        }
        retain.addAll(commonList);
        
		addAll.addAll(hashList1);
		addAll.addAll(hashList2);

	}
	
	
	/**
	 * combine two maps according to types of variables
	 * @param Map 1 with all types variable names
	 * @param Map 2 with all types variable names
	 * @return a combined map with all types variable names
	 */
	private Map<String, List<Integer>> combineHashMaps(Map<String, List<Integer>> map1, Map<String, List<Integer>> map2) {
		for(String key:map1.keySet()) {
			List<Integer> itemsList = map2.getOrDefault(key, new ArrayList<>());
			itemsList.addAll(map1.get(key));
			map2.put(key, itemsList);
		}
		return map2;
		
	}
	
	/**
	 * calculate similarity of variable of two repositories according to counts of variables
	 * @return a similarity of variable of two repositories according to counts of variables
	 */
	private float compareDeclaredVariables() {
		int count1 = 0, count2 = 0;
		for(String key:finalMap1.keySet()) {
			count1 += finalMap1.get(key).size();
		}
		for(String key:finalMap2.keySet()) {
			count2 += finalMap2.get(key).size();
		}
		if(Math.max(count1, count2)==0)
			return 1;
		return(float) Math.min(count1, count2)/Math.max(count1, count2);
	}
	
	// Map contains all types of variables and declared names of repository 1
	private Map<String, List<Integer>> finalMap1 = new HashMap<>();
	// Map contains all types of variables and declared names of repository 2
	private Map<String, List<Integer>> finalMap2 = new HashMap<>();
	// a indicator whether repository 1 has been processed
	private boolean flag = true;
}
