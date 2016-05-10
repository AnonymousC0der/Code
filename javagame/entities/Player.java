package javagame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;

import javagame.main.GamePanel;
import javagame.objects.Block;

public class Player {
	
	//movement
	private boolean right = false, left = false, jumping = false, falling = false;
	
	//bounds
	private double x, y;
	private int width, height;
	
	//velocity
	private int xvel = 1;
	private int yvel = 1;
	
	//jump speed
	private double jumpSpeed = 5;
	private double currentJumpSpeed = jumpSpeed;
	
	//fall speed
	private double maxFallSpeed = 2;
	private double currentFallSpeed = 0.1;
	
	public Player(int width, int height){
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		this.width = width;
		this.height = height;
	}
	
	public void tick(){
		
		int iX = (int)x;
		int iY = (int)y;
		
		
		if(right){
			x+= xvel;
		}
		if(left){
			x-= xvel;
		}
		
		
		if(jumping){
			y -= currentJumpSpeed;
			
			currentJumpSpeed -= 0.1;
			
			if(currentJumpSpeed <= 0){
				currentJumpSpeed = jumpSpeed;
				jumping = false;
				falling = true;
			}
		}
		if(falling){
			y+= currentFallSpeed;
			
			if(currentFallSpeed < maxFallSpeed){
				currentFallSpeed += 0.1;
			}
		}
		if (!falling){
			currentFallSpeed = 0.1;
		}
		
		
		
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect((int)x, (int)y, width, height);
	}
	
	public void keyPressed(int k){
		if(k == KeyEvent.VK_D) right = true;
		if(k == KeyEvent.VK_A) left = true;
		if(k == KeyEvent.VK_SPACE) jumping = true;
	}
	
	public void keyReleased(int k){
		if(k == KeyEvent.VK_D) right = false;
		if(k == KeyEvent.VK_A) left = false;
	}
	
	public boolean collision(Block b){
		int iX = (int)x;
		int iY = (int)y;
		if (b.contains(new Point(iX, iY)) || b.contains(new Point(iX, iY + height)) 
				|| b.contains(new Point(iX + width, iY)) || b.contains(new Point(iX + width, iY + height))){
			xvel = 0;
		}
		else{ xvel = 1;}
		
		
		return false;
	}


}
