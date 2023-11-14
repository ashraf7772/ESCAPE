package escape.states;

import java.awt.Graphics;

import escape.Game;

//this is going to be an abstract class //any class which extends the state class must contain the tick and render method
public abstract class State {
//coding the game state manager below but this can be done in a seperate class
    private static State currentState = null;
    
    public static void setState(State state){
    	currentState = state;
    }
    
    public static State getState(){
    	return currentState;
    }
	
	//these two have nothing to do with the gamestate manager they are seperate from the abstract part
	
    protected Game game;
    
    public State(Game game) {
    	this.game = game;
    }
    
    public abstract void tick();
	
	public abstract void render(Graphics g);

}
