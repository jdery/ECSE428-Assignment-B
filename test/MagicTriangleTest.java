import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jean-Sebastien Dery
 * @author Renaud Jacques-Dagenais
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
	public void testCharEntries() {
		String[] arguments = {"A", "B", "C"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testSpecialCharEntries() {
		String[] arguments = {"$", "@", "&"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testNullEntries() {
		String[] arguments = {null, null, null};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testMixedEntries() {
		String[] arguments = {"1", "4", null};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testSpaceEntries() {
		String[] arguments = {" ", " ", " "};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testLineFeedEntries() {
		String[] arguments = {"\n", "\n", "\n"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testTabEntries() {
		String[] arguments = {"\t", "\t", "\t"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testCarriageReturnEntries() {
		String[] arguments = {"\r", "\r", "\r"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}

	@Test
	public void testDifferentFloatingPointEntries() {
		String[] arguments = {"50.3", "1.59", "2.5"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}

	@Test
	public void testSameFloatingPointEntries() {
		String[] arguments = {"2.0", "2.0", "2.0"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}

	@Test
	public void testOneIntegerAndTwoLetters() {
		String[] arguments = {"1", "B", "C"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testTwoIntegersAndOneLetter() {
		String[] arguments = {"1", "2", "C"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.INVALID_INPUT_TYPE + "\n", outputContent.toString());
	}
	
	@Test
	public void testNegativeFirstEntry() {
		String[] arguments = {"-1", "3", "2"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.OUT_OF_RANGE_INPUT + "\n", outputContent.toString());
	}

	@Test
	public void testFirstEntryAboveRange() {
		String[] arguments = {"10000", "3", "2"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.OUT_OF_RANGE_INPUT + "\n", outputContent.toString());
	}
	
	@Test
	public void testNegativeSecondEntry() {
		String[] arguments = {"1", "-50", "20"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.OUT_OF_RANGE_INPUT + "\n", outputContent.toString());
	}
	
	@Test
	public void testSecondEntryAboveRange() {
		String[] arguments = {"1", "50000", "20"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.OUT_OF_RANGE_INPUT + "\n", outputContent.toString());
	}
	
	@Test
	public void testNegativeThirdEntry() {
		String[] arguments = {"1", "0", "-72"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.OUT_OF_RANGE_INPUT + "\n", outputContent.toString());
	}

	@Test
	public void testThirdEntryAboveRange() {
		String[] arguments = {"1", "0", "40000"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.OUT_OF_RANGE_INPUT + "\n", outputContent.toString());
	}
	
	@Test
	public void testThreeEntriesAboveRange() {
		String[] arguments = {"101", "101", "101"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.OUT_OF_RANGE_INPUT + "\n", outputContent.toString());
	}
	
	@Test
	public void testThreeZeroEntries() {
		String[] arguments = {"0", "0", "0"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.OUT_OF_RANGE_INPUT + "\n", outputContent.toString());
	}
	
	@Test
	public void testEuclidesProposition1() {
		String[] arguments = {"2", "1", "1"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.NOT_A_TRIANGLE + "\n", outputContent.toString());
	}
	
	@Test
	public void testEuclidesProposition2() {
		String[] arguments = {"1", "2", "1"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.NOT_A_TRIANGLE + "\n", outputContent.toString());
	}
	
	@Test
	public void testEuclidesProposition3() {
		String[] arguments = {"1", "1", "2"};
		MagicTriangle.isValidEntries(arguments);
		assertEquals(MagicTriangle.NOT_A_TRIANGLE + "\n", outputContent.toString());
	}
	
	@Test
	public void testSmallestEquilateralTriangle() {
		String[] arguments = {"1", "1", "1"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.EQUILATERAL + "\n", outputContent.toString());
	}

	@Test
	public void testMediumEquilateralTriangle() {
		String[] arguments = {"50", "50", "50"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.EQUILATERAL + "\n", outputContent.toString());
	}
	
	@Test
	public void testBiggestEquilateralTriangle() {
		String[] arguments = {"100", "100", "100"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.EQUILATERAL + "\n", outputContent.toString());
	}
	
	@Test
	public void testSmallestIsoscelesTriangle1() {
		String[] arguments = {"2", "2", "1"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.ISOSCELES + "\n", outputContent.toString());
	}
	
	@Test
	public void testSmallestIsoscelesTriangle2() {
		String[] arguments = {"1", "2", "2"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.ISOSCELES + "\n", outputContent.toString());
	}
	
	@Test
	public void testSmallestIsoscelesTriangle3() {
		String[] arguments = {"2", "1", "2"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.ISOSCELES + "\n", outputContent.toString());
	}
	
	@Test
	public void testMediumIsoscelesTriangle() {
		String[] arguments = {"2", "50", "50"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.ISOSCELES + "\n", outputContent.toString());
	}
	
	@Test
	public void testBiggestIsoscelesTriangle1() {
		String[] arguments = {"100", "100", "99"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.ISOSCELES + "\n", outputContent.toString());
	}

	@Test
	public void testBiggestIsoscelesTriangle2() {
		String[] arguments = {"100", "99", "100"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.ISOSCELES + "\n", outputContent.toString());
	}
	
	@Test
	public void testBiggestIsoscelesTriangle3() {
		String[] arguments = {"99", "100", "100"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.ISOSCELES + "\n", outputContent.toString());
	}
	
	@Test
	public void testSmallestScaleneTriangle1() {
		String[] arguments = {"2", "3", "4"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.SCALENE + "\n", outputContent.toString());
	}
	
	@Test
	public void testSmallestScaleneTriangle2() {
		String[] arguments = {"3", "2", "4"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.SCALENE + "\n", outputContent.toString());
	}
	
	@Test
	public void testSmallestScaleneTriangle3() {
		String[] arguments = {"2", "4", "3"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.SCALENE + "\n", outputContent.toString());
	}
	
	@Test
	public void testSmallestScaleneTriangle4() {
		String[] arguments = {"4", "3", "2"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.SCALENE + "\n", outputContent.toString());
	}
	
	@Test
	public void testMediumScaleneTriangle() {
		String[] arguments = {"49", "50", "51"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.SCALENE + "\n", outputContent.toString());
	}

	@Test
	public void testBiggestScaleneTriangle1() {
		String[] arguments = {"98", "99", "100"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.SCALENE + "\n", outputContent.toString());
	}
	
	@Test
	public void testBiggestScaleneTriangle2() {
		String[] arguments = {"99", "98", "100"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.SCALENE + "\n", outputContent.toString());
	}
	
	@Test
	public void testBiggestScaleneTriangle3() {
		String[] arguments = {"98", "100", "99"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.SCALENE + "\n", outputContent.toString());
	}
	
	@Test
	public void testBiggestScaleneTriangle4() {
		String[] arguments = {"100", "99", "98"};
		MagicTriangle.main(arguments);
		assertEquals(MagicTriangle.SCALENE + "\n", outputContent.toString());
	}
}
