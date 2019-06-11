package data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellArrayTest {
	CellArray cells=new CellArray(3,3);

	@Test
	void testGetCell() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				cells.setCell(i, j, 0);
			}
		}
		//错误用例
		assertEquals(-1,cells.getCell(4, 2));
		//正常情况
		assertEquals(0,cells.getCell(2, 2));
	}
	@Test
	void testSetCell() {
		//错误用例
		cells.setCell(4,2,1);
		//正常用例
		cells.setCell(2,2,1);
		assertEquals(1,cells.getCell(2, 2));
	}
	

}
