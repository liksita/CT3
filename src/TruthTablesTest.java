import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TruthTablesTest {

	@Test
	public void testSimpleConditionCoverageWithDecisionCoverage() {
		TruthTables table = new TruthTables();
		table.addTable(table.tableExample);
		ArrayList<int[]> coverage = table.simpleConditionCoverageWithDecisionCoverage();
		int[] simpleConditionCoverage1= {0,0,0,0};
		int[] simpleConditionCoverage2= {1,1,1,1};
		assertArrayEquals(coverage.get(0), simpleConditionCoverage1);
		assertArrayEquals(coverage.get(1), simpleConditionCoverage2);
		assertEquals(coverage.size(), 2);
	}
	
	@Test
	public void testSimpleConditionCoverage() {
		TruthTables table = new TruthTables();
		table.addTable(table.tableExample);
		ArrayList<int[]> coverage = table.simpleConditionCoverage();
		int[] simpleConditionCoverage1= {0,0,1,0};
		int[] simpleConditionCoverage2= {1,1,0,0};
		assertArrayEquals(coverage.get(0), simpleConditionCoverage1);
		assertArrayEquals(coverage.get(1), simpleConditionCoverage2);
		assertEquals(coverage.size(), 2);
	}
	
	@Test
	public void testMinimalDeterminingMultipleConditionCoverage() {
		TruthTables table = new TruthTables();
		table.addTable(table.tableExample);
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

}
