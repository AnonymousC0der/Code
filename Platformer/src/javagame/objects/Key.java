package javagame.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Key extends Rectangle{
	
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 20;
	private static final int HEIGHT = 20;
	BufferedImage img = null;
	
	public Key(int x, int y){
		setBounds(x, y, WIDTH, HEIGHT);
		try {
			img = ImageIO.read(new File("images/key.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void remove(){
		setBounds(800, 600, WIDTH, HEIGHT);
	}
	
	public void draw(Graphics g){
		//g.setColor(Color.WHITE);
		//g.fillRect(x, y, WIDTH, HEIGHT);
		g.drawImage(img, x, y, new ImageObserver(){

			@Override
			public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				return false;
			}
			
		});
	}

}
