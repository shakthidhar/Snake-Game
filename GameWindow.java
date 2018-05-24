import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	
	private GameDriver gameDriver;
	
	public GameWindow(){
		
		super();
		
		gameDriver = new GameDriver();
		
		// set up the frame
        this.setTitle("Snake Game");
        this.setLayout(new BorderLayout());
        this.add(gameDriver, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
	}

}
