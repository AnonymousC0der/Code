package javagame.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import javagame.entities.Player;

public class Block extends Rectangle{
	private static final long serialVersionUID = 1L;
	private static final int defaultBlockSize = 60;
	
	public Block(int x, int y){
		setBounds(x, y, defaultBlockSize, defaultBlockSize);
	}
	
	public Block(int x, int y, int sizeX, int sizeY){
		setBounds(x, y, sizeX, sizeY);
	}
	
	public void draw(Graphics g){
		g.fillRect(x, y, width, height);
	}
	
	
	
	
	

}
