package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/*
 * The test suite to run all the unit tests for the plagiarism detector application
 */
@RunWith(Suite.class)
@SuiteClasses({ AlgorithmFactoryTests.class, JavaPlagiarismDetectorTests.class, LCSAlgorithmTests.class, CommentVisitorTests.class, })
public class AllTests {

}
