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
	
	/**
	 * Test method for {@link MagicTriangle#findWhichTypeOfTriangle()}.
	 */
	@Test
	public void testFindWhichTypeOfTriangle() {
	}
}
