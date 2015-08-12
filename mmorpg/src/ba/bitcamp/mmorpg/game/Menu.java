package ba.bitcamp.mmorpg.game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class Menu extends BasicGameState {
	
	Image play;
	Image welcome;
	Image exit;
	Image ship1;
	Image ship2;
	Image ship3;
	Image ship4;
	
	/**
	 * constructor
	 */
	public Menu(int state) {

	}

	/**
	 * This method initializes the game
	 */
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		play = new Image("pics/play.png");
		exit = new Image("pics/exit.png");
		welcome = new Image("pics/welcomescreen.png");
		ship1 = new Image("pics/ship1.png");
		ship2 = new Image("pics/ship2.png");
		ship3 = new Image("pics/ship3.png");
		ship4 = new Image("pics/ship4.png");
		

	}

	/**
	 * This method draws on the screen
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		welcome.draw(0,0);
		play.draw(100, 350);
		exit.draw(390,360);
		ship3.draw(50,50);
		ship2.draw(165,50);
		ship1.draw(280,50);
		ship4.draw(395,50);
		g.drawString("Choose your ship!", 225, 250);
		

	}

	/**
	 * This method updates the images on the screen(moving the objects)
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
	int posX = Mouse.getX();
	int posY = Mouse.getY();
	
	if((posX > 100 && posX < 225) && (posY > 50 && posY < 175)){
		if(Mouse.isButtonDown(0)){
			sbg.enterState(1);
		}
	}
		
	if((posX > 390 && posX < 500) && (posY > 50 && posY < 160)){
		if(Mouse.isButtonDown(0)){
			System.exit(0);
		}
	}

	}

	/**
	 * This method returns the id of the state
	 */
	public int getID() {

		return 0;
	}

}
