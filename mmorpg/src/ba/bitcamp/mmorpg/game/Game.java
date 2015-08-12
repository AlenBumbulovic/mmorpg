package ba.bitcamp.mmorpg.game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {
	
	public static final String name = "Space";
	public static final int menu = 0;
	public static final int play = 1;
	
	public Game(String name){
		super(name);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		
	}
	
	
	/**
	 *this method manages the game states
	 */
	public void initStatesList(GameContainer gc) throws SlickException{
		
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		
		this.enterState(menu);

	}

	public static void main(String[] args) {
		
		AppGameContainer gameContainer;
		
		try{
			
			gameContainer = new AppGameContainer(new Game(name));
			gameContainer.setDisplayMode(600, 500, false);
			
			gameContainer.start();
			
			
		}catch (SlickException e){
			e.printStackTrace();
		}
		

	}

}
