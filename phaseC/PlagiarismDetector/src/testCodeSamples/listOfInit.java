package testCodeSamples;

/**
 * A test class of a list of initialization
 * @author kent4
 *
 */
public class listOfInit {
	public boolean test() {
		int a = 0;
		int b = a++;
		int c = a/b;
		int d = c-a;
		int e = 5;
		int f = 6;
		System.out.println(a+1*c);
		return a != b;
	}
}
