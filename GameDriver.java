import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GameDriver extends JPanel implements KeyListener, ActionListener {

	// Panel constants
    public static final int FRAME_WIDTH = 600;
    public static final int FRAME_HEIGHT = 600;
    
    private boolean gameOver;
    private Timer timer;
    private SnakeShape snake;
    private Random random;
    private Rectangle foodBlock;
    
    public GameDriver(){
    	
    	super();
    	
    	gameOver = false;
    	snake = new SnakeShape();
    	random = new Random();
    	// setup the timer and add ActionListener to Timer
        timer = new Timer(1000/6, this);
        timer.start();
        
        foodBlock = new Rectangle(random.nextInt(40)*SnakeShape.WIDTH+10, random.nextInt(40)*SnakeShape.HEIGHT+10,SnakeShape.WIDTH,SnakeShape.HEIGHT);
        
        // set up JPanel
        this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.setBackground(new Color(100, 160, 201));
        this.setFocusable(true);

        // register KeyListener to JPanel
        this.addKeyListener(this);
    	
    }
    
    @Override
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	snake.draw(g);
    	g.setColor(Color.black);
		g.drawRect(foodBlock.x, foodBlock.y,
				foodBlock.width, foodBlock.height);
		g.fillRect(foodBlock.x, foodBlock.y,
				foodBlock.width, foodBlock.height);
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(!gameOver){
			try{
				snake.move();
				if(snake.intesects(foodBlock)){
					foodBlock.setLocation(random.nextInt(40)*SnakeShape.WIDTH+10, random.nextInt(40)*SnakeShape.HEIGHT+10);
				}
			}catch(SnakeHitBorderException exception){
				gameOver = true;
			}
		}
		this.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			snake.addMove(-1,0);
			System.out.println("left");
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			snake.addMove(1,0);
			System.out.println("right");
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			snake.addMove(0,-1);
			System.out.println("up");
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			snake.addMove(0,1);
			System.out.println("down");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
