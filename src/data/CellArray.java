package data;

public class CellArray {
	/*ϸ���ľ�����Ӵ*/
	private int [][] cellArray; 
	private int row;
	private int col; 
	/*ϸ�������캯�� ��ʼ����״̬����Ҫ��ʼ��*/
	public CellArray(int row,int col) {
		this.row=row;
		this.col=col;
		cellArray=new int[row][col];
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	/*ϸ��״̬����*/
	public int getCell(int x,int y) {
		if(x>=0 && x<row && y>=0 && y<col)
			return cellArray[x][y];
		return -1;
	}
	public void setCell(int x,int y,int cell) {
		if(x>=0 && x<row && y>=0 && y<col)
		this.cellArray[x][y]=cell;
	}
	
	

}
