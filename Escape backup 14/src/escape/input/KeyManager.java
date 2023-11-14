package escape.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//key listener is a class java has which allows you to access the keyboard.
public class KeyManager implements KeyListener {
	
	private boolean[] keys;
	public boolean up, down, left, right;
	
	
	public KeyManager(){
		keys = new boolean[256];
	}
	public void tick(){
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
	}

	
	
	@Override
	public void keyPressed(KeyEvent k) {
		keys[k.getKeyCode()]= true;
		
	}

	@Override
	public void keyReleased(KeyEvent k) {
		keys[k.getKeyCode()]= false;
		
	}

	@Override
	public void keyTyped(KeyEvent k) {
	
		
	}

}
