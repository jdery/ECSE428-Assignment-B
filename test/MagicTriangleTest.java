import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
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
	public void testNonIntegerEntries1() {
		String[] arguments = {"A", "B", "C"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testNonIntegerEntries2() {
		String[] arguments = {"$", "@", "&"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	@Test
	public void testNonIntegerEntries3() {
		String[] arguments = {null, null, null};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testNonIntegerEntries4() {
		String[] arguments = {"1", "4", null};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testNonIntegerEntries5() {
		String[] arguments = {" ", " ", " "};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testNonIntegerEntries6() {
		String[] arguments = {"\n", "\n", "\n"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testNonIntegerEntries7() {
		String[] arguments = {"\t", "\t", "\t"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testNonIntegerEntries8() {
		String[] arguments = {"\r", "\r", "\r"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}

	@Test
	public void testNonIntegerEntries9() {
		String[] arguments = {"50.3", "1.59", "2.5"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testNonIntegerEntries10() {
		String[] arguments = {"2.0", "2.0", "2.0"};
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
	public void testOutOfRangeInputs5() {
		String[] arguments = {"101", "101", "101"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.OUT_OF_RANGE_INPUT + "\n", outputContent.toString());
	}
	
	@Test
	public void testOutOfRangeInputs6() {
		String[] arguments = {"0", "0", "0"};
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
	public void testValidInputsNotATriangle4() {
		String[] arguments = {"1", "1", "100"};
		MagicTriangle.main(arguments);
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
	public void testEquilateralTriangle4() {
		String[] arguments = {"100", "100", "100"};
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
	public void testIsoscelesTriangle5() {
		String[] arguments = {"100", "100", "1"};
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
	
	@Test
	public void testScaleneTriangle4() {
		String[] arguments = {"12", "6", "14"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.SCALENE + "\n", outputContent.toString());
	}
	
	@Test
	public void testScaleneTriangle5() {
		String[] arguments = {"5", "10", "13"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.SCALENE + "\n", outputContent.toString());
	}
}
