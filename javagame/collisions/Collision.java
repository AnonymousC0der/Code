package javagame.collisions;

import java.awt.Point;

import javagame.objects.Block;

public class Collision {
	
	public static boolean PlayerBlock(Point p, Block b){
		return b.contains(p);
	}

}
