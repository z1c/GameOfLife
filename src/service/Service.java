package service;

import java.util.Random;

import data.CellArray;
import data.CellState;

public class Service {
	public static int[] temp= {-1,0,1};
	/*�����ʼ��*/
	public static CellArray initMap(int row,int col) {
		CellArray cells=new CellArray(row,col);
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(i==j)
					cells.setCell(i, j, CellState.LIVE.getValue());
				else
					cells.setCell(i, j, CellState.DEAD.getValue());
				
				/*��ϵͳʱ��ĺ�����Ϊ�������������,����ÿ�γ�ʼ�����ϸ������ͬ*/
				/*Random r=new Random();
				int a=r.nextInt(4); /*������ķ�ΧΪ0-4
				if(a==1) {
					 cells.setCell(i, j, CellState.LIVE.getValue());
				}
				else {
					 cells.setCell(i, j, CellState.DEAD.getValue());
				}*/
			}
		}
		return cells;
	}
	/*��ϸ�������ؽ�Ӵ*/
	public static CellArray generate(CellArray cells) {
		CellArray nextCells=new CellArray(cells.getRow(),cells.getCol());
		int row=nextCells.getRow();
		int col=nextCells.getCol();
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				int count=countNumber(cells,i,j);
				/*������Χ8��ϸ����״̬�����Լ���״̬Ӵ*/
				if(count==3) {
					 nextCells.setCell(i, j, CellState.LIVE.getValue());
				}
				else if(count==2 && cells.getCell(i, j)==CellState.LIVE.getValue()) {
					 nextCells.setCell(i, j, CellState.LIVE.getValue());
				}
				else {
					 nextCells.setCell(i, j, CellState.DEAD.getValue());
				}
			}
		}
		return nextCells;
	}
	/*����ϸ����Χ8��ϸ���л�ϸ���ĸ���Ӵ*/
    public static int countNumber(CellArray cells,int x,int y) {
    	int count=0;
    	int i,j;
    	for(i=0;i<3;i++) {
    		for(j=0;j<3;j++) {
    			if(CellState.LIVE.getValue()==cells.getCell(x+temp[i], y+temp[j]))
    				count++; 
    		}
    	}
    	if(CellState.LIVE.getValue()==cells.getCell(x, y))
    		count--;
    	return count;
    }
}
