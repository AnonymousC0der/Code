package javagame.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import javagame.entities.Player;

public class Block extends Rectangle{
	private static final long serialVersionUID = 1L;
	private static final int blockSize = 64;
	
	public Block(int x, int y){
		setBounds(x, y, blockSize, blockSize);
	}
	
	public void draw(Graphics g){
		g.fillRect(x, y, width, height);
	}
	
	
	
	
	

}
