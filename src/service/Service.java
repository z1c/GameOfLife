package service;

import java.util.Random;

import data.CellArray;
import data.CellState;

public class Service {
	public static int[] temp= {-1,0,1};
	/*随机初始化*/
	public static CellArray initMap(int row,int col) {
		CellArray cells=new CellArray(row,col);
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(i==j)
					cells.setCell(i, j, CellState.LIVE.getValue());
				else
					cells.setCell(i, j, CellState.DEAD.getValue());
				
				/*以系统时间的毫秒数为种子生成随机数,所以每次初始化后的细胞矩阵不同*/
				/*Random r=new Random();
				int a=r.nextInt(4); /*随机数的范围为0-4
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
	/*对细胞矩阵重建哟*/
	public static CellArray generate(CellArray cells) {
		CellArray nextCells=new CellArray(cells.getRow(),cells.getCol());
		int row=nextCells.getRow();
		int col=nextCells.getCol();
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				int count=countNumber(cells,i,j);
				/*根据周围8个细胞的状态更改自己的状态哟*/
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
	/*计算细胞周围8个细胞中活细胞的个数哟*/
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
