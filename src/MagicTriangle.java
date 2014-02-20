/**
 * 
 */

/**
 * @author Jean-Sebastien Dery
 * @author Renaud Dagenais
 *
 */
public class MagicTriangle {
	
	private static int A, B, C;
	private static final int upperBound = 100;
	private static final int lowerBound = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Verifies if it's a triangle.
		if (args.length != 3) {
			System.out.println("Not a triangle");
			return;
		}
		
		// Verifies if the inputs are integers.
		try {
			A = Integer.parseInt(args[0]);
			B = Integer.parseInt(args[1]);
			C = Integer.parseInt(args[2]);
		} catch(Exception e) {
			System.out.println("Invalid input type");
			return;
		}
		
		// Verifies that the inputs are in the specified range.
		if (A > upperBound || A < lowerBound ||
				B > upperBound || B < lowerBound ||
				C > upperBound || C < lowerBound) {
			System.out.println("Out of range input");
			return;
		}
		
		// Determine if it is a triangle based on the input configuration.
		
	}
}
