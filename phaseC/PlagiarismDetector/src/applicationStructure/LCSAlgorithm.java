package applicationStructure;


import java.util.List;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * @author team-22
 * Class that contains implementation of a specific detection algorithm
 * Class that contains the longest common subsequence algorithm 
 * This algorithm takes sequences of AST nodes and returns the longest common sequence among them
 *
 */
public class LCSAlgorithm implements DetectionAlgorithm{

	/**
	 * @param ast1 - List of ASTs of the files in first input
	 * @param ast2 - List of ASTs of the files in second input
	 * @return Report object containing the similarity score among the two input
	 */
	@Override
	public Report compareAST(List<CompilationUnit> ast1, List<CompilationUnit> ast2) {
		
		//Converting the list of ASTs to a single string for comparison
		String astStr1 = getCombinedASTString(ast1);
		String astStr2 = getCombinedASTString(ast2);
		
		//get the length of the longest common subsequence among the two ASTs
		float lcsLength = getLCSLength(astStr1, astStr2);
		
		//get the similarity score of the two ASTs
		double similarity = getNormalizedSimilarity(astStr1, astStr2, lcsLength);
		
		//Creating a result object;
		Report result = new Report();
		result.setSimilarityScore(similarity *100);

		return result;		
	}
	
	/**
	 * Public method to access the private method getCombinedASTString() in tests
	 * @param astList - list of ASTs formed by parsing file input
	 * @return Single string formed by combining all ASTs in the list of ASTs
	 */
	public String getSingleString(List<CompilationUnit> astList){
		
		return getCombinedASTString(astList);
		
	}
	
	/**
	 * Method to iterate over a list of ASTs and form one single string for comparison later
	 * @param astList - list of ASTs formed by parsing file input
	 * @return Single string formed by combining all ASTs in the list of ASTs
	 */
	private String getCombinedASTString(List<CompilationUnit> astList){
		String result = "";
		
		for (CompilationUnit ast : astList){
			result += ast.toString();
		}
		
		return result;
		
	}
	
	/**
	 * Public method to access the private method getMaxLCS() in tests
	 * @param ast1 - String containing the combined ASTs form first input
	 * @param ast2 - String containing the combined ASTs form second input
	 * @return  Length of the common subsequence between the two ASTs
	 */
	public float getLCSLength(String ast1, String ast2){
		
		return getMaxLCS(ast1,ast2);
		
	}
	
	/**
	 * Method to get the length of longest common subsequence
	 * Uses dynamic programming to store computations
	 * @param ast1 - String containing the combined ASTs form first input
	 * @param ast2 - String containing the combined ASTs form second input
	 * @return Length of the common subsequence between the two ASTs
	 */
	private float getMaxLCS(String ast1, String ast2){
		
		//Get all the characters in both the ASTs
		char[] astStr1 = ast1.toCharArray();
		char[] astStr2 = ast2.toCharArray();
		
		//declare a similarity matrix to store results using dynamic programming
		int temp[][] = new int[astStr1.length + 1][astStr2.length + 1];
		
		//Variable to store the max length of the LCS
        int max = 0;
        
        //Using dynamic programming approach to find the longest common subsequence
        for(int i=1; i < temp.length; i++){
            for(int j=1; j < temp[i].length; j++){
                if(astStr1[i-1] == astStr2[j-1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                }
                else
                {
                    temp[i][j] = Math.max(temp[i][j-1],temp[i-1][j]);
                }
                if(temp[i][j] > max){
                    max = temp[i][j];
                }
            }
        }
        
        //Returning the longest common subsequence length
        return max;
		
	}
	
	/**
	 * Public Method to access the private method getSimilarity() in tests
	 * @param ast1 - String containing the combined ASTs form first input
	 * @param ast2 - String containing the combined ASTs form second input
	 * @param lcsLength - Length of the Longest Common Subsequence
	 * @return Similarity of the two AST strings
	 */
	public double getNormalizedSimilarity(String ast1,String ast2, float lcsLength){
		
		return getSimilarity(ast1,ast2,lcsLength);
		
	}
	/**
	 *  Method to calculate the normalized similarity using the LCS
	 * @param ast1 - String containing the combined ASTs form first input
	 * @param ast2 - String containing the combined ASTs form second input
	 * @param lcsLength - Length of the Longest Common Subsequence
	 * @return Similarity of the two AST strings
	 */
	public double getSimilarity(String ast1,String ast2, float lcsLength){
		int astStr1Len = ast1.toCharArray().length;
		int astStr2Len = ast2.toCharArray().length;
		if(astStr1Len!=astStr2Len && Math.min(astStr1Len, astStr2Len)==0)
			return 0;
		if(astStr1Len==0 && astStr2Len ==0)
			return 0;
		return 2*lcsLength / (astStr1Len + astStr2Len);	
	}
	
	
	
}
