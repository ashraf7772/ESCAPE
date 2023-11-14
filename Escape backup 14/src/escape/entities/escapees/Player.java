package escape.entities.escapees;

import java.awt.Graphics;

import escape.Game;
import escape.gfx.Parts;

public class Player extends escapees {

	
	public Player(Game game,float x, float y) {
		super(game, x, y, escapees.STARTING_ESCAPEES_HEIGHT, escapees.STARTING_ESCAPEES_WIDTH);
	}

	@Override //player updates its variables here
	public void tick() {
		getInput();
		move();
	
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up)
			yMove = -speed;
		if(game.getKeyManager().down)
			yMove = speed;
		if(game.getKeyManager().left)
			xMove = -speed;
		if(game.getKeyManager().right)
			xMove = speed;
		
		
	}

	@Override //player draws t self here
	public void render(Graphics g) {//here we do casting
		g.drawImage(Parts.player,(int) x ,(int) y, width, height, null);
	}

}
