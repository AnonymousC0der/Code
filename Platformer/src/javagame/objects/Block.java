package javagame.objects;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Rectangle;

import javagame.entities.Player;

/**
 * 
 * @author Vishal Narayan and David Lung
 * The Block class defines a standard platform
 * block, which is used by the level classes to 
 * construct each level. Block extends Rectangle, 
 * which allows it to set boundaries and use various
 * collision detection methods. 
 *
 */

public class Block extends Rectangle{
	private static final long serialVersionUID = 1L;
	private static final int blockSize = 60;
	
	/**
	 * Constructs Block object with default block size
	 * and puts it at the passed position.
	 * @param x the x-coordinate of the block
	 * @param y the y-coordinate of the block
	 */
	public Block(int x, int y){
		setBounds(x, y, blockSize, blockSize);
		
	}
	
	/**
	 * Constructs Block object with the passed block size
	 * and puts it at the passed position. 
	 * @param x the x-coordinate of the block
	 * @param y the y-coordinate of the block
	 * @param sizeX the width of block
	 * @param sizeY the height of block
	 */
	public Block(int x, int y, int sizeX, int sizeY){
		setBounds(x, y, sizeX, sizeY);
	}

	
	
	/**
	 * Draws the block
	 * @param g the Graphics object passed
	 */
	public void draw(Graphics g){
		g.setColor(new Color(204, 204, 0));
		g.fillRect(x, y, width, height);
	}
	
	
	
	
	

}
