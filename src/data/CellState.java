package data;

public enum CellState {
	DEAD(0),LIVE(1); //细胞的状态只有死 活两种实例
	private int value;
	
	CellState(int value){
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
	
	

}
