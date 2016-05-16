import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class TruthTablesTest {
	
	public ArrayList<int[]> tableExample1 = new ArrayList<int[]>();
	public ArrayList<int[]> tableExample2 = new ArrayList<int[]>();

	
	public int[] v1 = { 0, 0, 0, 0 };
	public int[] v2 = { 0, 0, 1, 0 };
	public int[] v3 = { 0, 1, 0, 0 };
	public int[] v4 = { 0, 1, 1, 0 };
	public int[] v5 = { 1, 0, 0, 0 };
	public int[] v6 = { 1, 0, 1, 0 };
	public int[] v7 = { 1, 1, 0, 0 };
	public int[] v8 = { 1, 1, 1, 1 };
	
	public int[] vect1 = { 0, 0, 0, 1 };
	public int[] vect2 = { 1, 0, 0, 0 };
	public int[] vect3 = { 0, 1, 0, 0 };
	public int[] vect4 = { 1, 1, 0, 0 };
	public int[] vect5 = { 0, 0, 1, 1 };
	public int[] vect6 = { 1, 0, 1, 0 };
	public int[] vect7 = { 0, 1, 1, 1 };
	public int[] vect8 = { 1, 1, 1, 0 };
	
	@Before
	public void setUp() throws Exception {
		tableExample1.add(v1);
		tableExample1.add(v2);
		tableExample1.add(v3);
		tableExample1.add(v4);
		tableExample1.add(v5);
		tableExample1.add(v6);
		tableExample1.add(v7);
		tableExample1.add(v8);
		
		tableExample2.add(vect1);
		tableExample2.add(vect2);
		tableExample2.add(vect3);
		tableExample2.add(vect4);
		tableExample2.add(vect5);
		tableExample2.add(vect6);
		tableExample2.add(vect7);
		tableExample2.add(vect8);
	}


	@Test
	public void testSimpleConditionCoverageWithDecisionCoverage1() {
		TruthTables table = new TruthTables();
		table.addTable(tableExample1);
		ArrayList<int[]> coverage = table.simpleConditionCoverageWithDecisionCoverage();
		int[] simpleConditionCoverage1= {0,0,0,0};
		int[] simpleConditionCoverage2= {1,1,1,1};
		assertArrayEquals(coverage.get(0), simpleConditionCoverage1);
		assertArrayEquals(coverage.get(1), simpleConditionCoverage2);
		assertEquals(coverage.size(), 2);
	}
	
	@Test
	public void testSimpleConditionCoverageWithDecisionCoverage2() {
		TruthTables table = new TruthTables();
		table.addTable(tableExample2);
		ArrayList<int[]> coverage = table.simpleConditionCoverageWithDecisionCoverage();
		int[] simpleConditionCoverage1= {0,0,0,1};
		int[] simpleConditionCoverage2= {1,1,1,0};
		assertArrayEquals(coverage.get(0), simpleConditionCoverage1);
		assertArrayEquals(coverage.get(1), simpleConditionCoverage2);
		assertEquals(coverage.size(), 2);
	}
	
	@Test
	public void testSimpleConditionCoverage1() {
		TruthTables table = new TruthTables();
		table.addTable(tableExample1);
		ArrayList<int[]> coverage = table.simpleConditionCoverage();
		int[] simpleConditionCoverage1= {0,0,1,0};
		int[] simpleConditionCoverage2= {1,1,0,0};
		assertArrayEquals(coverage.get(0), simpleConditionCoverage1);
		assertArrayEquals(coverage.get(1), simpleConditionCoverage2);
		assertEquals(coverage.size(), 2);
	}
	
	@Test
	public void testSimpleConditionCoverage2() {
		TruthTables table = new TruthTables();
		table.addTable(tableExample2);
		ArrayList<int[]> coverage = table.simpleConditionCoverage();
		int[] simpleConditionCoverage1= {0,1,0,0};
		int[] simpleConditionCoverage2= {1,0,1,0};
		assertArrayEquals(coverage.get(0), simpleConditionCoverage1);
		assertArrayEquals(coverage.get(1), simpleConditionCoverage2);
		assertEquals(coverage.size(), 2);
	}
	
	@Test
	public void testMinimalDeterminingMultipleConditionCoverage1() {
		TruthTables table = new TruthTables();
		table.addTable(tableExample1);
		ArrayList<int[]> coverage = table.minimalDeterminingMultipleConditionCoverage();
		int[] simpleConditionCoverage1= {0,1,1,0};
		int[] simpleConditionCoverage2= {1,0,1,0};
		int[] simpleConditionCoverage3= {1,1,0,0};
		int[] simpleConditionCoverage4= {1,1,1,1};
		assertArrayEquals(coverage.get(0), simpleConditionCoverage1);
		assertArrayEquals(coverage.get(1), simpleConditionCoverage2);
		assertArrayEquals(coverage.get(2), simpleConditionCoverage3);
		assertArrayEquals(coverage.get(3), simpleConditionCoverage4);
		assertEquals(coverage.size(), 4);
	}
	
	@Test
	public void testMinimalDeterminingMultipleConditionCoverage2() {
		TruthTables table = new TruthTables();
		table.addTable(tableExample2);
		ArrayList<int[]> coverage = table.minimalDeterminingMultipleConditionCoverage();
		int[] simpleConditionCoverage1= {0,0,0,1};
		int[] simpleConditionCoverage2= {1,0,0,0};
		int[] simpleConditionCoverage3= {0,1,0,0};
		int[] simpleConditionCoverage4= {0,0,1,1};
		int[] simpleConditionCoverage5= {1,0,1,0};
		int[] simpleConditionCoverage6= {0,1,1,1};
		int[] simpleConditionCoverage7= {1,1,1,0};
		assertArrayEquals(coverage.get(0), simpleConditionCoverage1);
		assertArrayEquals(coverage.get(1), simpleConditionCoverage2);
		assertArrayEquals(coverage.get(2), simpleConditionCoverage3);
		assertArrayEquals(coverage.get(3), simpleConditionCoverage4);
		assertArrayEquals(coverage.get(4), simpleConditionCoverage5);
		assertArrayEquals(coverage.get(5), simpleConditionCoverage6);
		assertArrayEquals(coverage.get(6), simpleConditionCoverage7);
		assertEquals(coverage.size(), 7);
	}

}
