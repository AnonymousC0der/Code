package javagame.entities;

import java.awt.Color;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;

import javagame.main.GamePanel;
import javagame.objects.*;

/**
 * 
 * @author Vishal Narayan and David Lung
 * Player class represents the player of the game.
 * It contains an x and y coordinate, and also
 * defines movement and block collision detections.
 *
 */

public class Player extends Rectangle{
	
	public static int LIVES = 5;
	public static boolean hasKey = false;
	//movement
	private boolean right = false, left = false, jumping = false, falling = false;
	
	//bounds
	private double x, y;
	private int width, height;
	
	//velocity
	private double xvel = 2;
	private double yvel = 8;
	
	//jump speed
	
	//fall speed
	private double maxFallSpeed = 2;
	private double currentFallSpeed = 0.1;

	private boolean bounce = false;
	private boolean moving = false;
	
	
	/**
	 * Construct a Player and sets its position
	 * at the center of the screen, and sets its
	 * width and height to the parameters passed.
	 * @param width the width of Player
	 * @param height the height of Player
	 */
	public Player(int width, int height, int xpos, int ypos){
		x = xpos;
		y = ypos;
		this.width = width;
		this.height = height;
		setBounds((int)x, (int)y, width, height);
		hasKey = false;
	}
	
	/**
	 * This method is the game loop for Player,
	 * and repeats every frame.
	 */
	public void tick(){
		
		int iX = (int)x;
		int iY = (int)y;
		
		if (right){
			x += xvel;
		}
		if(left){
			x-=xvel;
		}
		
		if (jumping){
			
			y -= yvel;
			yvel -= 0.1;
			if (yvel <= 0){
				yvel = 8;
				jumping = false;
				falling = true;
			}
			
			
		}
		if (falling){
			y+= currentFallSpeed;
			
			if(currentFallSpeed < maxFallSpeed){
				currentFallSpeed += 0.1;
			}
		}
		
		this.setLocation((int)x, (int)y);
		checkBounds();
		
		
		
	}
	private void checkBounds(){
		if (x < 0){
			left = false;
			x = 0;
		}
		else if (x+width > GamePanel.WIDTH){
			right = false;
			x = GamePanel.WIDTH - width;
		}
		else if (y < 0){
			yvel = 0;
			jumping = false;
			falling = true;
			y = 0;
		}
		else if (y+height > GamePanel.HEIGHT){
			falling = false;
			y = GamePanel.HEIGHT - height;
			if (bounce) jumping = true;
		}
	}
	
	private Rectangle getBoundsTop(){
		return new Rectangle((int)x+2, (int)y, width-4, height/2);
	}
	private Rectangle getBoundsBot(){
		return new Rectangle((int)x+2, (int)y+(height/2), width-4, height/2);
	}
	private Rectangle getBoundsLeft(){
		return new Rectangle((int)x, (int)y+2, 2, height-4);
	}
	private Rectangle getBoundsRight(){
		return new Rectangle((int)x+width-2, (int)y+2, 2, height-4);
	}
	
	
	/**
	 * Draws the Player
	 * @param g the Graphics object used to draw
	 */
	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect((int)x, (int)y, width, height);
		//g.fillOval((int)x, (int)y, width, height);
	}
	
	/**
	 * Checks if a key is pressed, and sets the 
	 * movement boolean accordingly.
	 * @param k the integer passed
	 */
	public void keyPressed(int k){
		if(k == KeyEvent.VK_D){
			moving = true;
			right = true;
		}
		if(k == KeyEvent.VK_A){
			moving = true;
			left = true;
		}
		if(k == KeyEvent.VK_W){
			bounce  = true;
			if(!falling){
			    jumping = true;
			}
		}
	}
	
	/**
	 * Checks if a key is released, and sets the
	 * movement boolean accordingly.
	 * @param k
	 */
	public void keyReleased(int k){
		if(k == KeyEvent.VK_D){
			moving = false;
			right = false;
		}
		if(k == KeyEvent.VK_A){
			moving = false;
			left = false;
		}
		if(k == KeyEvent.VK_W) bounce = false;
	}
	
	
	/**
	 * Checks if the player is touching a Block
	 * object, and sets the respective instructions.
	 * @param b the Block object to check collision
	 */
	public void collision(Block b){
		double bbY = b.getY()+b.getHeight();
		falling = true;
		
		
		if (b.intersects(getBoundsTop())){
			yvel = 0;
			jumping = false;
			falling = true;
			y = bbY;
		}
		if (b.intersects(getBoundsBot())){
			falling = false;
			y = b.getY() - height;
			if (bounce) jumping = true;
		}
		if(b.intersects(getBoundsRight())){
			right = false;
			x = b.getX() - width;
			if(moving) right = true;
		}
		if (b.intersects(getBoundsLeft())){
			left = false;
			x = b.getX()+b.getWidth();
			if (moving) left = true;
		}
		
	}
	
	public boolean checkDoor(Door d){
		if (d.intersects(this)){
			return true;
		}else{return false;}
		
	}
	public boolean checkFire(Fire f){
		if (f.intersects(this)){
			return true;
		}
		else{return false;}
	}
	
	public void checkKey(Key k){
		if (k.intersects(this)){
			hasKey = true;
			k.remove();
		}
	}
	


}
