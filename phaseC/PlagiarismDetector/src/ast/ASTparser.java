package ast;

import java.io.File;
import java.io.IOException;
import java.util.*;
import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.JavaCore;

/**
 * * @author team-22
 * This class contains logic to parse a file and generate an AST using Eclipse JDT
 *
 */
public class ASTparser{
	
	//Variable to store the AST parser
	private ASTParser parser;

	//Map to store the mapping of the AST to the file from which it was generated
	private Map<CompilationUnit, String> astToFileContentMap;

	//Variable to store contents of a file
	private String fileContent;
	
	//Constructor to initialize several parameters
	public ASTparser() {
		parser = ASTParser.newParser(AST.JLS9);
	    parser.setKind(ASTParser.K_COMPILATION_UNIT);
	    Map<String, String> compilerOptions = JavaCore.getOptions();
	    compilerOptions.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_7); //set java version
	    compilerOptions.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_7);
	    compilerOptions.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_7);
	    parser.setCompilerOptions(compilerOptions); //setting compile configuration
	    
	    setFileContent("");
	    astToFileContentMap = new HashMap<CompilationUnit, String>();
	}
	
	/**
	 * Creates the AST of the files input to the program using the eclipse JDT.
	 * @param filepath - The file/directory path provided in input
	 * @return The AST of the java  code in the file input
	 */
	public CompilationUnit createASTFromInput(String filepath) {
		ReadFile reader = new ReadFile();
		try {
			//Reading the file contents to string
			setFileContent(reader.readFileToString(filepath));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//providing the characters of the code in the file to the parser
	    char[] src = getFileContent().toCharArray();
	    parser.setSource(src);
	    
	    //IProgessMonitor,set null to return root of AST
	    return (CompilationUnit) parser.createAST(null); 
	     
	}
	
	/**
	 * create a list of ASTs for files under input file/directory path
	 * @param dirPath - The file/directory path 
	 * @return a list of ASTs of files in this input file/directory path
	 */
	public List<CompilationUnit> createListOfAST(String dirPath){
		
		//Creating a file/files based on the input path provided
		final File folder = new File(dirPath);
		
		//List of ASTs of files generated through the input
		List<CompilationUnit> re = new ArrayList<>();
		
		//Variable to store a single AST
		CompilationUnit ast;
		
		//Checking if the file input is a single '.java' file
		if(!folder.isDirectory() && folder.getAbsolutePath().matches("(.*)\\.java")) {
			
			//generating the AST of the '.java' file and adding to list of ASTs
            ast = createASTFromInput(folder.getAbsolutePath());
			re.add(ast);
			
			//generating the mapping of AST and the corresponding file content from
			//which it was generated 
			astToFileContentMap.put(ast,getFileContent());
            
			return re;
            
		}
		
		//Iterate over the files if input path is nested
		for (final File fileEntry : folder.listFiles()) {
			
			//Recursively call the AST creating function, if input is directory and files 
			//are present within the directory
	        if (fileEntry.isDirectory()) {
	        	
	        	//Adding all the ASTs to single list
	            re.addAll(createListOfAST(fileEntry.getAbsolutePath()));
	            
	        } else {	        		
        		if(fileEntry.getAbsolutePath().matches("(.*)\\.java")) {
        			//generating the AST of the '.java' file and adding to list of ASTs
            		ast = createASTFromInput(fileEntry.getAbsolutePath());
            		re.add(ast);
            		
            		//generating the mapping of AST and the corresponding file content from
    				//which it was generated
            		astToFileContentMap.put(ast,getFileContent());
        		}
	        }
	    }
		return re;
	}
	
	/**
	 * 
	 * @return File content of the single input file that is being parsed
	 */
	public String getFileContent() {
		return fileContent;
	}
	
	/**
	 * Sets the File content of the single input file that is being parsed
	 * @param fileContent
	 */
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	
	/**
	 * 
	 * @return a Hashmap of AST as the key and corresponding content of the file as the value,
	 * 			through which the AST was generated.
	 */
	public Map<CompilationUnit, String> getAstToFileContentMap() {
		return astToFileContentMap;
	}
	
	/**
	 *  Sets the Hashmap of AST as the key and corresponding content of the file as the value,
	 * 	through which the AST was generated.
	 * @param astToFileContentMap
	 */
	public void setAstToFileContentMap(Map<CompilationUnit, String> astToFileContentMap) {
		this.astToFileContentMap = astToFileContentMap;
	}
}