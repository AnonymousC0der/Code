package javagame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Fire extends Rectangle {
	
	private static final long serialVersionUID = 1L;
	private int width, height;
	
	public Fire(int x, int y, int w, int h){
		setBounds(x, y, w, h);
		width = w;
		height = h;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}

}
