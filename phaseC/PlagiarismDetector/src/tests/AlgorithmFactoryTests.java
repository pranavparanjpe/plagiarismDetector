package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import applicationStructure.*;

public class AlgorithmFactoryTests {
	private EditDistanceAlgorithm editDistance;
	private HashingAlgorithm hashing;
	private LCSAlgorithm lcs;
	private static AlgorithmFactory f;
	
	//Creating an instance of the algorithm factory
	@BeforeClass
	public static void createFactory(){
		f = AlgorithmFactory.instance();
	}
	
	//Testing the object creation for EditDistanceAlgorithm
	@Test
	public void testEditDistanceCreation() {
		editDistance = f.createEditDistance();
		assertEquals(editDistance instanceof EditDistanceAlgorithm,true);
	}
	
	//Testing the object creation for HashingAlgorithm
	@Test
	public void testHashingCreation() {
		hashing = f.createHashingAlgorithm();
		assertEquals(hashing instanceof HashingAlgorithm,true);
	}
	
	//Testing the object creation for LCSAlgorithm
	@Test
	public void testlcsCreation() {
		lcs = f.createLCSAlgorithm();
		assertEquals(lcs instanceof LCSAlgorithm,true);
	}

}
