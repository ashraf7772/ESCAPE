package escape.entities.escapees; //super method refers to the class its extended from
import escape.Game;
import escape.entities.Entity;

public abstract class escapees extends Entity {
	
	public static final int STARTING_HEALTH = 10;
	public static final float STARTING_SPEED = 8.0f;
	public static final int STARTING_ESCAPEES_WIDTH=64,
							STARTING_ESCAPEES_HEIGHT=64;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	
	
	public escapees(Game game, float x, float y, int width, int height) {
		super(game, x, y, width, height);
		health = STARTING_HEALTH;
		speed = STARTING_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move(){
		x += xMove;
	    y += yMove;
	}
//getters and setters
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
