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
		//generate�����Ǹ�����һ��ϸ��Ⱥ�壬���չ����������һ�����ֵ�״̬
		
		//�ô����������ı�д���Ǹ��伫�������ϸ��Ⱥ��
		CellArray cells=new CellArray(40,40);
		int[][] testCell=new int[40][40];
		int i,j;
		boolean flag;
		//��ʼ���Ա�ϸ��Ⱥ��testCells
		for(i=0;i<40;i++) {
			for(j=0;j<40;j++) {
				testCell[i][j]=0;
			}
		}
		//������������
		
		//��Ե����
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
		
		//��������
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
		//������Խ������
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
     //���Լ�����߼��Ƿ���ȷ
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
		//���Ա߽�ϸ��
		assertEquals(1,Service.countNumber(cells, 0, 0));
	}
}
