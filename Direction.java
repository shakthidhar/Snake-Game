
public class Direction{
	
	private int dir_x;
	private int dir_y;
	
	public Direction(int _dir_x, int _dir_y){
		dir_x = _dir_x;
		dir_y = _dir_y;
	}
	
	public void changeDir(int _dir_x, int _dir_y){
		dir_x = _dir_x;
		dir_y = _dir_y;
	}
	
	public int getX(){
		return dir_x;
	}
	
	public int getY(){
		return dir_y;
	}
	
	public boolean notOpposite(int _dir_x, int _dir_y){
		_dir_x = _dir_x*(-1);
		_dir_y = _dir_y*(-1);
		
		if(_dir_x == dir_x && _dir_y == dir_y){
			return false;
		}else{
			return true;
		}
	}

}
