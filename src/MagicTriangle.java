/**
 * @author Jean-Sebastien Dery
 * @author Renaud Dagenais
 * 
 */
public class MagicTriangle {

	private static int A, B, C;

	private static final int upperBound = 100;
	private static final int lowerBound = 1;
	public static final String NOT_A_TRIANGLE = "Not a triangle";
	public static final String INVALID_INPUT_TYPE = "Invalid input type";
	public static final String OUT_OF_RANGE_INPUT = "Out of range input";
	public static final String EQUILATERAL = "Equilateral";
	public static final String ISOSCELES = "Isosceles";
	public static final String SCALENE = "Scalene";

	/**
	 * The main function that is expected to have three integers as inputs.
	 * 
	 * @param args
	 *            The integers that will define the triangle.
	 */
	public static void main(String[] args) {
		if (isValidEntries(args)) {
			findWhichTypeOfTriangle();
		}
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
	public static boolean isValidEntries(String arguments[]) {
		// Verifies if it's a triangle.
		if (arguments.length != 3) {
			System.out.println(NOT_A_TRIANGLE);
			return (false);
		}

		// Verifies if the inputs are integers.
		try {
			A = Integer.parseInt(arguments[0]);
			B = Integer.parseInt(arguments[1]);
			C = Integer.parseInt(arguments[2]);
		} catch (Exception e) {
			System.out.println(INVALID_INPUT_TYPE);
			return (false);
		}

		// Verifies that the inputs are in the specified range.
		if (A > upperBound || A < lowerBound || B > upperBound
				|| B < lowerBound || C > upperBound || C < lowerBound) {
			System.out.println(OUT_OF_RANGE_INPUT);
			return (false);
		}

		// Determine if it is a triangle based on the input configuration.
		if (!((A + B) > C && (A + C) > B && (B + C) > A)) {
			System.out.println(NOT_A_TRIANGLE);
			return (false);
		}
		
		return (true);
	}
	
	/**
	 * Find which type of triangle it is.
	 * 
	 * @param arguments The arguments that will determine which type of triangle it is.
	 */
	public static void findWhichTypeOfTriangle() {
		if (A == B && A == C && B == C) {
			System.out.println(EQUILATERAL);
			return;
		}
		
		if (A == B || B == C || A == C) {
			System.out.println(ISOSCELES);
			return;
		}
		
		System.out.println(SCALENE);
	}
}
