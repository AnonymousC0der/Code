package javagame.gameState;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javagame.entities.Player;
import javagame.objects.Block;

public class Level1State extends GameState{
	
	private Player player;
	private List<Block> blocks;
	
	public Level1State(GameStateManager gsm){
		super(gsm);
	}

	
	public void init() {
		player = new Player(30, 30);
		player.setFalling(true);
		blocks = new ArrayList<Block>();
		blocks.add(new Block(100, 400, 600, 200));
		//blocks.add(new Block(0, 0, 200, 600));
	}

	
	public void tick() {
		player.tick();
		for (Block b : blocks){
			player.collision(b);
		}
	}

	
	public void draw(Graphics g) {
		player.draw(g);
		for (Block b: blocks){
			b.draw(g);
		}
		
	}

	
	public void keyPressed(int k) {
		player.keyPressed(k);
		
	}

	 
	public void keyReleased(int k) {
		player.keyReleased(k);
		
	}
	

}
