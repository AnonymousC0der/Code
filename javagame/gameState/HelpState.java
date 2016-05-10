package javagame.gameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javagame.main.GamePanel;

public class HelpState extends GameState {
	
	private String help = "what's good ninjas";
	private String back = "back";
	
	public HelpState(GameStateManager gsm){
		super(gsm);
	}

	
	public void init() {
		
		
	}

	
	public void tick() {
		
		
	}

	
	public void draw(Graphics g) {
		g.setColor(new Color(50, 150, 200));
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		
		g.setFont(new Font("Arial", Font.PLAIN, 72));
		g.setColor(Color.GRAY);
		g.drawString(help, 300, 300);
		g.setColor(Color.GREEN);
		g.drawString(back, 100, 500);
		
	}

	
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER){
			gsm.states.push(new MenuState(gsm));
		}
		
	}

	
	public void keyReleased(int k) {
		
		
	}
	
	

}
