package javagame.gameState;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javagame.entities.Fire;
import javagame.entities.Player;
import javagame.main.GamePanel;
import javagame.objects.Block;
import javagame.objects.Door;
import javagame.objects.Key;

public class Level2State extends GameState {
	
	private String lives = "Lives: " + Player.LIVES;
	private String StringKey = "";
	private Player player;
	private Door door;
	private Key key;
	private List<Block> blocks;
	private List<Fire> fires;

	public Level2State(GameStateManager gsm) {
		super(gsm);
		
	}

	
	public void init() {
		player = new Player(20, 20, 20, 300);
		door = new Door(0, 60);
		key = new Key(600, 200);
		blocks = new ArrayList<Block>();
		blocks.add(new Block(60, GamePanel.HEIGHT - 60, GamePanel.WIDTH-60, 60));
		blocks.add(new Block(120, GamePanel.HEIGHT - 120, GamePanel.WIDTH-120, 60));
		blocks.add(new Block(180, GamePanel.HEIGHT - 180, GamePanel.WIDTH-180, 60));
		blocks.add(new Block(240, GamePanel.HEIGHT - 240, GamePanel.WIDTH-240, 60));
		blocks.add(new Block(300, GamePanel.HEIGHT - 300, GamePanel.WIDTH-300, 60));
		
		blocks.add(new Block(0, 160, 250, 40));
		fires = new ArrayList<Fire>();
	}

	
	public void tick() {
		player.tick();
		player.checkKey(key);
		if (player.hasKey){
			StringKey = "Key: Yes";
		}
		else{
			StringKey = "Key: No";
		}
		for (Block b : blocks){
			player.collision(b);
		}
		for (Fire f: fires){
			if(player.checkFire(f)){
				if (player.LIVES > 1){
					player.LIVES -= 1;
					System.out.println(player.LIVES);
					gsm.states.push(new Level2State(gsm));
				}else{
					gsm.states.push(new EndState(gsm));
				}
			}
		}
		if (player.checkDoor(door)){
			if (player.hasKey){
				gsm.states.push(new Level3State(gsm));
			}
		}
	}

	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		g.setColor(Color.WHITE);
		g.drawString(lives, 10, 15);
		g.drawString(StringKey, 400, 15);
		for (Block b: blocks){
			b.draw(g);
		}
		for (Fire f: fires){
			f.draw(g);
		}
		door.draw(g);
		key.draw(g);
		player.draw(g);
		
	}

	
	public void keyPressed(int k) {
		player.keyPressed(k);
		
	}

	
	public void keyReleased(int k) {
		player.keyReleased(k);
		
	}
	
	

}
