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
	private static final String NOT_A_TRIANGLE = "Not a triangle";
	private static final String INVALID_INPUT_TYPE = "Invalid input type";
	private static final String OUT_OF_RANGE_INPUT = "Out of range input";

	/**
	 * The main function that is expected to have three integers as inputs.
	 * 
	 * @param args
	 *            The integers that will define the triangle.
	 */
	public static void main(String[] args) {
		validateEntries(args);

		
	}

	/**
	 * Valid the entries that were inputed in the main function.
	 * 
	 * It will display the appropriate error message and will terminate if an
	 * error is discovered.
	 * 
	 * @param arguments
	 *            The arguments to be validated.
	 */
	public static void validateEntries(String arguments[]) {
		// Verifies if it's a triangle.
		if (arguments.length != 3) {
			System.out.println(NOT_A_TRIANGLE);
			return;
		}

		// Verifies if the inputs are integers.
		try {
			A = Integer.parseInt(arguments[0]);
			B = Integer.parseInt(arguments[1]);
			C = Integer.parseInt(arguments[2]);
		} catch (Exception e) {
			System.out.println(INVALID_INPUT_TYPE);
			return;
		}

		// Verifies that the inputs are in the specified range.
		if (A > upperBound || A < lowerBound || B > upperBound
				|| B < lowerBound || C > upperBound || C < lowerBound) {
			System.out.println(OUT_OF_RANGE_INPUT);
			return;
		}

		// Determine if it is a triangle based on the input configuration.
		if (!((A + B) > C && (A + C) > B && (B + C) > A)) {
			System.out.println(NOT_A_TRIANGLE);
			return;
		}
	}
}
