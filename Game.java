
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame implements ActionListener, KeyListener{

	private TestSquare p1;
	private boolean[] key;
	private boolean gameIsRunning = true;
	
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Game frame = new Game();
                frame.setTitle("Square Move Practice");
                frame.setResizable(false);
                frame.setSize(600, 600);
                frame.setMinimumSize(new Dimension(600, 600));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(frame.p1);
                frame.pack();
                frame.setVisible(true);
            }
        });	
		
	}
	
	public Game(){
		this.p1 = new TestSquare();
		addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        
        long lastLoopTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;  
		long lastFpsTime = 0;
		int fps = 0;

		while (gameIsRunning){
		   long now = System.nanoTime();
		   long updateLength = now - lastLoopTime;
		   lastLoopTime = now;
		   double timePassed = updateLength / ((double)OPTIMAL_TIME);

		   lastFpsTime += updateLength;
		   fps++;
		      
		   if (lastFpsTime >= 1000000000)
		   {
		      System.out.println("(FPS: "+fps+")");
		      lastFpsTime = 0;
		      fps = 0;
		   }
		      
		   doGameUpdates(timePassed);
		   }
	}	
		
	
	public void doGameUpdates(double delta){
		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("button 1"))
			System.out.println("button 1");
		if (command.equals("button 2"))
			System.out.println("button 2");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		key[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		key[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	
	
}
