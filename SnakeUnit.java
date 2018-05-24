import java.awt.Rectangle;

@SuppressWarnings("serial")
public class SnakeUnit extends Rectangle {
	
	private Direction dir;
	
	public SnakeUnit(int x, int y, int width, int height,int dir_x, int dir_y){
		super(x, y, width, height);
		dir = new Direction(dir_x,dir_y);
	}
	
	public Direction getDirection(){
		return dir;
	}
	
	public void setDirection(int _dir_x, int _dir_y){
		dir.changeDir(_dir_x, _dir_y);
	}
	
}
