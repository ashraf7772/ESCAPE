package escape;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import escape.display.Display;
import escape.gfx.GameCamera;
import escape.gfx.ImageLoader;
import escape.gfx.Parts;
import escape.gfx.SpriteSheet;
import escape.input.KeyManager;
import escape.states.GameState;
import escape.states.InfiniteModeState;
import escape.states.MenuState;
import escape.states.SettingsState;
import escape.states.State;

public class Game implements Runnable {

	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy buffer;
	private Graphics g;
	
	//states
	private State gameState;
	private State menuState;
	private State settingsState;
	private State infinitemodeState;
	
	//INPUTS
	private KeyManager keyManager;
	
	//camera
	private GameCamera gameCamera;
		
	
	
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Parts.init();      
		
		gameCamera = new GameCamera(0, 0);
		
		gameState = new GameState(this); //we use this because we just using This class
		menuState = new MenuState(this);
		settingsState = new SettingsState(this);
		infinitemodeState = new InfiniteModeState(this);
		State.setState(gameState);
		//test = ImageLoader.LoadImage("/textures/spritesheet.png"); // /=access so /textures/test.png means access textures and access test 
	    //sheet = new SpriteSheet(test);
	}
	
		private void tick(){
			keyManager.tick();
			
			if(State.getState() != null)
				State.getState().tick();
		}
	
	
	
	private void render(){ //the purpose of this is to prevent flickering
		buffer = display.getCanvas().getBufferStrategy();
		if(buffer == null){ // these are drawn on the first buffer screen then second then the actual screen
			display.getCanvas().createBufferStrategy(3); //this tells the computer how many buffers you need three is the limit
			return;
		}
		g = buffer.getDrawGraphics(); //essentially a paint brush which allows you to decorate the frame
		//Clear screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		
		
		if(State.getState() != null)
			State.getState().render(g);
		
		//End Drawing!
		buffer.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		//working on frames per second
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double also = 0;// also variable is to show the amount of time until we have to call the tick and render method again
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			also += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
		  if(also >= 1) {
			 tick(); 
			 render();
			 ticks++;
			 also--;
	}                                                //this does everything over and over again
	
		if (timer >= 1000000000) {
			System.out.println("Ticks and Frames: " + ticks);
			ticks = 0;
			timer = 0;
		
		}
		}	
		
		stop();
		
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
		}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}
    public int getHeight(){
    	return height;
    }
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}



 