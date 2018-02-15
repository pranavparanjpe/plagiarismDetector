package applicationStructure;

import java.util.List;

import org.eclipse.jdt.core.dom.*;

/*
 * @author - team-22
 * Interface describing the steps taken to compare two input files for plagiarism
 */
public interface DetectionAlgorithm {
	 
	 /*
	  * Method to compare the generated list of ASTs by applying the algorithm and get a report
	  */
	 public Report compareAST(List<CompilationUnit> ast1, List<CompilationUnit> ast2);
}
