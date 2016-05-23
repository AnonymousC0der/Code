package javagame.gameState;

import java.awt.Graphics;

/**
 * 
 * @author Vishal Narayan and David Lung
 * Class GameState is an abstract class which declares
 * multiple methods for each of its inheritors to 
 * implement. It constructs a GameStateManager object.
 *
 */

public abstract class GameState {
	
	protected GameStateManager gsm;
	protected double xOffset, yOffset;
	
	/**
	 * Assigns gsm to a GameStateManager
	 * @param gsm the GameStateManager to be initiated.
	 */
	public GameState(GameStateManager gsm){
		this.gsm = gsm;
		
		this.xOffset = 0;
		this.yOffset = 0;
		
		init();
	}
	/**
	 * Initializes the object
	 */
	public abstract void init();
	/**
	 * Repeats every frame for the object
	 */
	public abstract void tick();
	/**
	 * Draws the object
	 * @param g the Graphics object passed
	 */
	public abstract void draw(Graphics g);
	/**
	 * Performs actions when a key is pressed
	 * @param k the integer passed
	 */
	public abstract void keyPressed(int k);
	/**
	 * Performs actions when a key is released
	 * @param k the integer passed
	 */
	public abstract void keyReleased(int k);
	

}
