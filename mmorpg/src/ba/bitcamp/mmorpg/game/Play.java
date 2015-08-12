package ba.bitcamp.mmorpg.game;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
	
	Image map;
	Animation ship, movingUp, movingDown, movingLeft, movingRight;
	boolean quit = false;
	int[] duration = {200,200};
	float shipPositionX = 0;
	float shipPositionY = 0;
	float shiftX = shipPositionX + 220;
	float shiftY = shipPositionY + 200;
	
	
	/**
	 * 
	 * constructor
	 */
	public Play(int state) {

	}

	/**
	 * This method initializes the game
	 */
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
		map = new Image("pics/map.png");
		Image[] flyUp = {new Image("pics/ship1.png"), new Image("pics/ship1.png")};
		Image[] flyDown = {new Image("pics/ship1down.png"), new Image("pics/ship1down.png")};
		Image[] flyLeft = {new Image("pics/ship1left.png"), new Image("pics/ship1left.png")};
		Image[] flyRight = {new Image("pics/ship1right.png"), new Image("pics/ship1right.png")};
		
		movingUp = new Animation(flyUp, duration, false);
		movingDown = new Animation(flyDown, duration, false);
		movingLeft = new Animation(flyLeft, duration, false);
		movingRight = new Animation(flyRight, duration, false);
		ship = movingUp;
		

	}

	/**
	 * This method draws on the screen
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		map.draw(shipPositionX, shipPositionY);
		ship.draw(shiftX,shiftY);
		g.drawString("Ship position X: " + shipPositionX + "\nShip position Y: " + shipPositionY, 400, 20);
		
		if(quit == true){
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main menu (M)", 250, 120);
			g.drawString("Quit (Q)", 250, 140);
			
			if(quit == false){
				g.clear();
			}
		}
	}

	/**
	 * This method updates the images on the screen(moving the objects)
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_UP)){
			ship = movingUp;
			shipPositionY += delta * .1f;
			
			if(shipPositionY > 213){
				shipPositionY -= delta * .1f;
		}
		}
		
		if(input.isKeyDown(Input.KEY_DOWN)){
			ship = movingDown;
			shipPositionY -= delta * .1f;
			
			if(shipPositionY < -2675){
				shipPositionY += delta * .1f;
			}
		}
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			ship = movingRight;
			shipPositionX -= delta * .1f;
			
			if(shipPositionX < -3769){
				shipPositionX += delta * .1f;
			}
			
			
		}
		
		if(input.isKeyDown(Input.KEY_LEFT)){
			ship = movingLeft;
			shipPositionX += delta * .1f;
			
			if(shipPositionX > 234){
				shipPositionX -= delta * .1f;
			}
		}
		
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			quit = true;
		}
		
		if(quit == true){
			if(input.isKeyDown(Input.KEY_R)){
				quit = false;
			}
			if(input.isKeyDown(Input.KEY_M)){
				sbg.enterState(0);
			}
			if(input.isKeyDown(Input.KEY_Q)){
				System.exit(0);
			}
			
		}

	}

	/**
	 * This method returns the id of the state
	 */
	public int getID() {

		return 1;
	}

}
