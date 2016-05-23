package javagame.gameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javagame.main.GamePanel;

/**
 * 
 * @author Vishal Narayan and David Lung
 * Class HelpState represents the screen of instructions
 * that is displayed when "HELP" is selected from the
 * main menu. It extends GameState, which is an abstract 
 * class, and also prompts the user to press <Enter> to
 * go back to the main menu.
 *
 */

public class HelpState extends GameState {
	//User Documentation
	private String help = " – Use WASD keys to move the character ";
	private String help1 = " – Get the key to go to next level";
	private String help2 = " – Objective– to complete all 10 levels ";
	private String help3 = " – You have 5 lives ";
	private String help4 = " – If you hit red, you lose a life";
	
	private String enter = "Press [Enter] to go back to main menu";
	
	
	/**
	 * Calls the super method of the GameStateManager.
	 * @param gsm the GameStateManager passed.
	 */
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
		
		
		g.setFont(new Font("Arial", Font.PLAIN, 40));
		g.setColor(Color.WHITE);
		g.drawString(help, 0, 100);
		g.drawString(help1, 0, 200);
		g.drawString(help2, 0, 300);
		g.drawString(help3, 0, 400);
		g.drawString(help4, 0, 500);
		//Press enter to go back home
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString(enter, 225, 550);
		g.setColor(Color.GREEN);
		
	}

	
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER){
			gsm.states.push(new MenuState(gsm));
		}
		
	}

	
	public void keyReleased(int k) {}
		
		
	
	
	

}
