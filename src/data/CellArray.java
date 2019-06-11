package data;

public class CellArray {
	/*细胞的矩阵定义哟*/
	private int [][] cellArray; 
	private int row;
	private int col; 
	/*细胞矩阵构造函数 初始构造状态仍需要初始化*/
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
	/*细胞状态控制*/
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
