package javagame.gameState;

import java.awt.Color;
import java.awt.Graphics;

import javagame.main.GamePanel;

public class EndState extends GameState {
	
	private String end = "Game Over";

	public EndState(GameStateManager gsm) {
		super(gsm);
	}

	
	public void init() {}

	
	public void tick() {}

	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		g.setColor(Color.white);
		g.drawString(end, 200, 400);
		
	}

	
	public void keyPressed(int k) {
		
		
	}

	
	public void keyReleased(int k) {
		
		
	}
	

}
