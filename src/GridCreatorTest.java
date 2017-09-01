package src;
import static org.junit.Assert.*;

import org.junit.Test;

public class GridCreatorTest {

	@Test
	public void checkColumsPerDigitCalculation() {
		LCDGridCreator gridCreator = new LCDGridCreator();
		gridCreator.setSize(3);
		
		gridCreator.setColumnsPerDigit();
		
		assertEquals(5, gridCreator.getColumnsPerDigit());
	}
	
	@Test
	public void checkRowTotalCalculation() {
		LCDGridCreator gridCreator = new LCDGridCreator();
		gridCreator.setSize(5);
		
		gridCreator.setRowTotal();
		
		assertEquals(13, gridCreator.getRowTotal());
	}
	
	@Test
	public void checkColTotalCalculation() {
		LCDGridCreator gridCreator = new LCDGridCreator();
		gridCreator.setSize(5);
		gridCreator.setColumnsPerDigit();
		
		gridCreator.setColTotal("12345", 2);
		
		assertEquals(45, gridCreator.getColTotal());
	}	
	
	
	@Test
	public void checkFixedPoint1Calculation() {
		LCDGridCreator gridCreator = new LCDGridCreator();
		gridCreator.setSize(2);
		gridCreator.setColumnsPerDigit();
		gridCreator.setPivotX(3);
		gridCreator.setRowTotal();
		
		int[] expected = {0, 7};
		gridCreator.setFixedPoint1();
		
		assertArrayEquals(expected, gridCreator.getFixedPoint1());
	}
	
	@Test
	public void checkFixedPoint2Calculation() {
		LCDGridCreator gridCreator = new LCDGridCreator();
		gridCreator.setSize(2);
		gridCreator.setColumnsPerDigit();
		gridCreator.setPivotX(3);
		gridCreator.setRowTotal();
		
		int[] expected = {3, 7};
		gridCreator.setFixedPoint2();
		
		assertArrayEquals(expected, gridCreator.getFixedPoint2());
	}
	
	@Test
	public void checkFixedPoint3Calculation() {
		LCDGridCreator gridCreator = new LCDGridCreator();
		gridCreator.setSize(2);
		gridCreator.setColumnsPerDigit();
		gridCreator.setPivotX(3);
		gridCreator.setRowTotal();
		
		int[] expected = {6, 7};
		gridCreator.setFixedPoint3();
		
		assertArrayEquals(expected, gridCreator.getFixedPoint3());
	}
	
	@Test
	public void checkFixedPoint4Calculation() {
		LCDGridCreator gridCreator = new LCDGridCreator();
		gridCreator.setSize(2);
		gridCreator.setColumnsPerDigit();
		gridCreator.setPivotX(3);
		gridCreator.setRowTotal();
		
		int[] expected = {3, 10};
		gridCreator.setFixedPoint4();
		
		assertArrayEquals(expected, gridCreator.getFixedPoint4());
	}
	
	@Test
	public void checkFixedPoint5Calculation() {
		LCDGridCreator gridCreator = new LCDGridCreator();
		gridCreator.setSize(2);
		gridCreator.setColumnsPerDigit();
		gridCreator.setPivotX(3);
		
		int[] expected = {0, 10};
		gridCreator.setFixedPoint5();
		
		assertArrayEquals(expected, gridCreator.getFixedPoint5());
	}
}
