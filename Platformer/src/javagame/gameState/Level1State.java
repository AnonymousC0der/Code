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

/**
 * 
 * @author Vishal Narayan and David Lung
 * 
 * Class Level1State represents the first level of the platform 
 * game. Level1 extends GameState, which is an abstract class, and
 * creates a new instance of Player, while checking for collisions.
 *
 */

public class Level1State extends GameState{
	
	private String lives = "Lives: " + Player.LIVES;
	private String StringKey;
	private Player player;
	private Door door;
	private Key key;
	private List<Block> blocks;
	private List<Fire> fires;
	
	/**
	 * Calls the super method of GameStateManager constructor
	 * @param gsm the GameStateManager constructor passed
	 */
	public Level1State(GameStateManager gsm){
		super(gsm);
	}

	
	public void init() {
		player = new Player(20, 20, 20, 300);
		blocks = new ArrayList<Block>();
		blocks.add(new Block(0, 540, GamePanel.WIDTH, 60));
		door = new Door(740, 440);
		key = new Key(400, 400);
		fires = new ArrayList<Fire>();
		fires.add(new Fire(400, 500, 50, 50));
		
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
		//checks collision for each block in the level
		for (Block b : blocks){
			player.collision(b);
		}
		for (Fire f: fires){
			if(player.checkFire(f)){
				if (player.LIVES > 1){
					player.LIVES -= 1;
					System.out.println(player.LIVES);
					gsm.states.push(new Level1State(gsm));
				}else{
					gsm.states.push(new EndState(gsm));
				}
			}
		}
		
		if (player.checkDoor(door)){
			if (player.hasKey){
				//player.hasKey = false;
				gsm.states.push(new Level2State(gsm));
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
