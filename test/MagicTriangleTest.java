import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author dery
 *
 */
public class MagicTriangleTest {
	private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outputContent));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.setOut(null);
	}
	
	@Test
	public void testNoEntries() {
		String[] arguments = {};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.NOT_A_TRIANGLE + "\n", outputContent.toString());
	}
	
	@Test
	public void testLessEntries() {
		String[] arguments = {"1", "1"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.NOT_A_TRIANGLE + "\n", outputContent.toString());
	}
	
	@Test
	public void testMoreEntries() {
		String[] arguments = {"1", "1", "1", "1"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.NOT_A_TRIANGLE + "\n", outputContent.toString());
	}
	
	@Test
	public void test10Entries() {
		String[] arguments = {"1", "1", "1", "1", "1", "1", "1", "1", "1", "1"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.NOT_A_TRIANGLE + "\n", outputContent.toString());
	}
	
	@Test
	public void testNonIntegerEntries() {
		String[] arguments = {"A", "B", "C"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testNonIntegerExceptOneEntries() {
		String[] arguments = {"1", "B", "C"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testNonIntegerExceptTwoEntries() {
		String[] arguments = {"1", "2", "C"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testOutOfRangeInputs1() {
		String[] arguments = {"-1", "3", "2"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.OUT_OF_RANGE_INPUT + "\n", outputContent.toString());
	}
	
	@Test
	public void testOutOfRangeInputs2() {
		String[] arguments = {"10000", "3", "2"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.OUT_OF_RANGE_INPUT + "\n", outputContent.toString());
	}
	
	@Test
	public void testOutOfRangeInputs3() {
		String[] arguments = {"1", "-50", "20"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.OUT_OF_RANGE_INPUT + "\n", outputContent.toString());
	}
	
	@Test
	public void testOutOfRangeInputs4() {
		String[] arguments = {"1", "0", "40000"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.OUT_OF_RANGE_INPUT + "\n", outputContent.toString());
	}
	
	@Test
	public void testValidInputsNotATriangle1() {
		String[] arguments = {"1", "2", "1"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.NOT_A_TRIANGLE + "\n", outputContent.toString());
	}
	
	@Test
	public void testValidInputsNotATriangle2() {
		String[] arguments = {"2", "1", "1"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.NOT_A_TRIANGLE + "\n", outputContent.toString());
	}
	
	@Test
	public void testValidInputsNotATriangle3() {
		String[] arguments = {"1", "1", "2"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.NOT_A_TRIANGLE + "\n", outputContent.toString());
	}
	
	@Test
	public void testEquilateralTriangle1() {
		String[] arguments = {"1", "1", "1"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.EQUILATERAL + "\n", outputContent.toString());
	}
	
	@Test
	public void testEquilateralTriangle2() {
		String[] arguments = {"10", "10", "10"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.EQUILATERAL + "\n", outputContent.toString());
	}
	
	@Test
	public void testEquilateralTriangle3() {
		String[] arguments = {"4", "4", "4"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.EQUILATERAL + "\n", outputContent.toString());
	}
	
	@Test
	public void testIsoscelesTriangle1() {
		String[] arguments = {"2", "2", "1"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.ISOSCELES + "\n", outputContent.toString());
	}
	
	@Test
	public void testIsoscelesTriangle2() {
		String[] arguments = {"1", "2", "2"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.ISOSCELES + "\n", outputContent.toString());
	}
	
	@Test
	public void testIsoscelesTriangle3() {
		String[] arguments = {"2", "50", "50"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.ISOSCELES + "\n", outputContent.toString());
	}
	
	@Test
	public void testIsoscelesTriangle4() {
		String[] arguments = {"100", "100", "50"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.ISOSCELES + "\n", outputContent.toString());
	}
	
	@Test
	public void testScaleneTriangle1() {
		String[] arguments = {"20", "30", "32"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.SCALENE + "\n", outputContent.toString());
	}
	
	@Test
	public void testScaleneTriangle2() {
		String[] arguments = {"15", "14", "21"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.SCALENE + "\n", outputContent.toString());
	}
	
	@Test
	public void testScaleneTriangle3() {
		String[] arguments = {"21", "42", "22"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.SCALENE + "\n", outputContent.toString());
	}
	
	/**
	 * Test method for {@link MagicTriangle#findWhichTypeOfTriangle()}.
	 */
	@Test
	public void testFindWhichTypeOfTriangle() {
	}
}
