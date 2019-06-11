package service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.CellArray;

class ServiceTest {

	@Test
	void testGenerate() {
		//generate本身是根据上一个细胞群体，按照规则决定其下一次曾现的状态
		
		//该处测试用例的编写就是给其极端情况的细胞群体
		CellArray cells=new CellArray(40,40);
		int[][] testCell=new int[40][40];
		int i,j;
		boolean flag;
		//初始化对比细胞群体testCells
		for(i=0;i<40;i++) {
			for(j=0;j<40;j++) {
				testCell[i][j]=0;
			}
		}
		//构建测试用例
		
		//边缘用例
		flag=true;
		for(i=0;i<40;i++) {
			for(j=0;j<40;j++) {
				cells.setCell(i, j, 0);
			}
		}
		cells=Service.generate(cells);
		here1:for(i=0;i<40;i++) {
			   for(j=0;j<40;j++) {
				if(cells.getCell(i, j)!=testCell[i][j]) {
					flag=false;
					break here1;
				}
			   }
		}
		assertTrue(flag==true);
		
		//错误用例
		for(i=0;i<40;i++) {
			for(j=0;j<40;j++) {
				cells.setCell(i, j, 0);
			}
		}
		cells.setCell(19, 19, 1);
		cells.setCell(19, 20, 1);
		cells.setCell(20, 19, 1);
		cells.setCell(20, 20, 1);
		cells=Service.generate(cells);
		//理想测试结果设置
		testCell[19][19]=1;
		testCell[19][20]=1;
		testCell[20][19]=1;
		testCell[20][20]=1;
		
		here2:for(i=0;i<40;i++) {
			    for(j=0;j<40;j++) {
				 if(cells.getCell(i, j)!=testCell[i][j]) {
					flag=false;
					break here2;
				 }
			    }
		}
		assertTrue(flag==true);
		
	}
	
	@Test
	void testCountNumber() {
     //测试计算的逻辑是否正确
		CellArray cells=new CellArray(5,5);
		int i,j;
		for(i=0;i<5;i++) {
			for(j=0;j<5;j++) {
				if(i==j)
					cells.setCell(i, j, 1);
				else
					cells.setCell(i, j, 0);
			}
		}
		assertEquals(2,Service.countNumber(cells, 3, 3));
		//测试边界细胞
		assertEquals(1,Service.countNumber(cells, 0, 0));
	}
}
