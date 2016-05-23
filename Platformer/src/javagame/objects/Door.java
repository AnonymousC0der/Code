package javagame.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Door extends Rectangle{
	
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 100;
	BufferedImage img = null;
	

	public Door(int x, int y){
		setBounds(x, y, WIDTH, HEIGHT);
		try {
			//URL url = new URL("http://cdn.grid.fotosearch.com/CSP/CSP991/k11626234.jpg");
			img = ImageIO.read(new File("images/door.png"));
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics g){
		//g.setColor(Color.ORANGE);
		//g.fillRect(x, y, width, height);
		g.drawImage(img, x, y, new ImageObserver(){

			@Override
			public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				return false;
			}
			
		});
	}
}
