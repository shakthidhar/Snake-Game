
public class Move {
	
	private int dir_x;
	private int dir_y;
	private int blocksMoved;
	
	public Move(int _dir_x, int _dir_y){
		dir_x = _dir_x;
		dir_y = _dir_y;
		blocksMoved = 0;
	}
	
	public int getX(){
		return dir_x;
	}
	
	public int getY(){
		return dir_y;
	}
	
	public void incrementMoved(){
		blocksMoved++;
	}
	
	public int getMoved(){
		return blocksMoved;
	}
}
