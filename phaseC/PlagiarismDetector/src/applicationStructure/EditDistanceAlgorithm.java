package applicationStructure;


import org.eclipse.jdt.core.dom.*;
import java.util.*;

/**
 * Class of Plagiarism Detection by edit Distance Algorithm
 * @author team-22
 */
public class EditDistanceAlgorithm implements DetectionAlgorithm{
	
	
	/**
	 * compare two lists of AST for plagiarism detection
	 * @param List of ASTs of input 1
	 * @param List of ASTs of input 2
	 * @return a report with similarity of two files
	 */
	public Report compareAST(List<CompilationUnit> cu1, List<CompilationUnit> cu2) {
		Report report = new Report();
		
		// generate two strings contain content of all files in two repositories
		String input1 = generateStringFromList(cu1);
		String input2 = generateStringFromList(cu2);
		
		// calculate similarity between two strings via edit distance
        double score = sim(input1,input2);
        
        // set the similarity of the report
		report.setSimilarityScore(100* score);
		return report;
	}
	
	
	/**
	 * generate the string that contains content of all files (ASTs)
	 * @param A list of ASTs
	 * @return A String with the content of the list of files (ASTs)
	 */
	private String generateStringFromList(List<CompilationUnit> cu) {
		String result = "";
		for(CompilationUnit c:cu) {
			result += c.toString();
		}
		return result;
	}
	
	
	/**
	 * return the minimum value among three elements
	 * @param element one
	 * @param element two
	 * @param element three
	 * @return the minimum value of three elements
	 */
	private int min(int one, int two, int three) { 
        return one<two && one<three?	one:(two<one && two<three?	two:three);  
    }  
     
	
	/**
	 * calculate similarity of two strings by edit distance
	 * @param the string with content of input 1
	 * @param the string with content of input 2
	 * @return the similarity of theses two strings
	 */
    private int editDistOfStrings(String str1, String str2) {  
        int n = str1.length();  
        int m = str2.length();  
        if(n == 0 || m==0) {  
            return n==0?	m:n;  
        }  
        return dynamicProgramming(str1,str2,n,m);
    }  
    
    
    /**
     * process of dynamic programming in edit distance
     * @param the string with content of input 1
     * @param the string with content of input 2
     * @param length of string 1
     * @param length of string 2
     * @return the similarity of these two strings
     */
    private int dynamicProgramming(String str1, String str2, int n, int m) {
    	int[][] d = new int[n+1][m+1];
    	initializeDp(d,str1,str2,n,m);
    	return generateDp(d,str1,str2,n,m);
    }
    
    
    /**
     * parse the 2-d array and assign values to this array
     * @param 2-d array perform dynamic programming
     * @param the string with content of input 1
     * @param the string with content of input 2
     * @param the length of string 1
     * @param the length of string 2
     * @return the similarity of these two strings
     */
    private int generateDp(int[][] d, String str1, String str2, int n, int m) {
        for(int i=1; i<=n; i++) {  
            for(int j=1; j<=m; j++) {  
                int addition = str1.charAt(i-1)==str2.charAt(j-1)?	0:1;  
                d[i][j] = min(d[i-1][j]+1, d[i][j-1]+1, d[i-1][j-1]+addition);  
            }  
        }  
        return d[n][m];  
    }
    
    
    /**
     * initialize the 2-d arrays
     * @param 2-d array perform dynamic programming
     * @param the string with content of input 1
     * @param the string with content of input 2
     * @param the length of string 1
     * @param the length of string 2
     */
    private void initializeDp(int[][] d, String str1, String str2, int n, int m) {
    	for(int i=0; i<=n; i++) {   
            d[i][0] = i;  
        }  
        for(int j=0; j<=m; j++) {    
            d[0][j] = j;  
        }  
    }
     
    
    /**
     * calculate the similarity of two strings
     * @param the string with content of input 1
     * @param the string with content of input 2
     * @return similarity of these two strings
     */
    private double sim(String str1, String str2) {  
    	if(Math.max(str1.length(), str2.length())==0)
    		return 0;
        return 1 - (double) editDistOfStrings(str1, str2) / Math.max(str1.length(), str2.length());  
    }  
}
