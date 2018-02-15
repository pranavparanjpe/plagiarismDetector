package applicationStructure;

/**
 * 
 * @author Team-22 Class that creates a plagiarism detector algorithm based on
 *         the type Accepts the factory as a parameter for object creation Types
 *         are EditDistance,Hashing
 */
public class AlgorithmCreator {

	public DetectionAlgorithm create(AlgorithmFactory f, AlgorithmType type) {
		return type==AlgorithmType.EditDistance?	f.createEditDistance():f.createHashingAlgorithm();
	}
}
