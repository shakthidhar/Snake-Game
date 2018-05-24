import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class SnakeShape {
	
	private ArrayList<SnakeUnit> bodyUnits;
	
	public final int START_X = 10;
	public final int START_Y = 10;
	
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	
	private ArrayList<Rectangle> foodBlocks;
	
	public SnakeShape(){
		bodyUnits = new ArrayList<SnakeUnit>();
		foodBlocks = new ArrayList<Rectangle>();
		createShape();
	}
	
	private void createShape(){
		
		for(int  i=2; i > -1 ; i--){
			SnakeUnit block = new SnakeUnit(START_X+(i*WIDTH*1),
					START_Y+(i*HEIGHT*0),WIDTH,HEIGHT,1,0);
			bodyUnits.add(block);
		}
		
	}
	
	public void addMove(int dirX, int dirY){
		
		if( bodyUnits.get(0).getDirection().notOpposite(dirX, dirY)){
			bodyUnits.get(0).setDirection(dirX, dirY);
		}
	}
	
	public void move() throws SnakeHitBorderException{
		for(int i=0; i < bodyUnits.size() ; i++){
			
			bodyUnits.get(i).x = bodyUnits.get(i).x + (WIDTH*bodyUnits.get(i).getDirection().getX());
			bodyUnits.get(i).y = bodyUnits.get(i).y + (HEIGHT*bodyUnits.get(i).getDirection().getY());
			
			if(bodyUnits.get(i).x <=0 || bodyUnits.get(i).x >= GameDriver.FRAME_WIDTH){
				throw new SnakeHitBorderException();
			}
			
			if(bodyUnits.get(i).y <=0 || bodyUnits.get(i).y >= GameDriver.FRAME_HEIGHT){
				throw new SnakeHitBorderException();
			}
		}
		
		for(int i=0;  i < foodBlocks.size(); i++){
			if(contains(foodBlocks.get(i))){
				addUnit();
				foodBlocks.remove(i);
				i--;
			}
		}
		
		for(int i=bodyUnits.size()-1; i > 0; i--){
			SnakeUnit prev = bodyUnits.get(i-1);
			bodyUnits.get(i).setDirection(prev.getDirection().getX(), prev.getDirection().getY());
		}
	}
	
	public void draw(Graphics g) {
        // draw rectangle
		
		for(int i=0; i < bodyUnits.size(); i++){
			g.setColor(Color.black);
			g.drawRect(bodyUnits.get(i).x, bodyUnits.get(i).y,
					bodyUnits.get(i).width, bodyUnits.get(i).height);
			g.fillRect(bodyUnits.get(i).x, bodyUnits.get(i).y,
					bodyUnits.get(i).width, bodyUnits.get(i).height);
		}
		
    }
	
	private void addUnit(){
		SnakeUnit lastUnit = bodyUnits.get(bodyUnits.size()-1);
		bodyUnits.add(
				new SnakeUnit(lastUnit.x - (WIDTH*lastUnit.getDirection().getX()), 
				lastUnit.y - (HEIGHT*lastUnit.getDirection().getY()),
				WIDTH,
				HEIGHT,
				lastUnit.getDirection().getX(),
				lastUnit.getDirection().getY())
				);
	}
	
	public boolean intesects(Rectangle foodBlock){
		 if(foodBlock.intersects(bodyUnits.get(bodyUnits.size()-1))){
			 foodBlocks.add(foodBlock);
			 return true;
		 }else{
			 return false;
		 }
	}
	
	public boolean contains(Rectangle foodBlock){
		return foodBlock.contains(bodyUnits.get(bodyUnits.size()-1));
	}

}
