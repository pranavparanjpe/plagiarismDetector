package applicationStructure;

/**
 * @author Team-22 Factory class to create different algorithm objects It
 *         implements Singleton Pattern to generate factory instance
 */
public class AlgorithmFactory {

	private static AlgorithmFactory _theFactory = null;

	private AlgorithmFactory() {
	}

	public static AlgorithmFactory instance() {
		if (_theFactory == null) {
			_theFactory = new AlgorithmFactory();
		}
		return _theFactory;
	}

	/**
	 * Method to create Edit Distance algorithm
	 */
	public EditDistanceAlgorithm createEditDistance() {
		return new EditDistanceAlgorithm();
	}

	/**
	 * Method to create Hashing algorithm
	 */
	public HashingAlgorithm createHashingAlgorithm() {
		return new HashingAlgorithm();
	}

	/**
	 * Method to create Longest Common Subsequence algorithm
	 */
	public LCSAlgorithm createLCSAlgorithm() {
		return new LCSAlgorithm();
	}
}
