package escape.gfx;   //this class is for assets so stuff like images or music

import java.awt.image.BufferedImage;
//only going to be used once to make the game more efficient
	public class Parts {
	
	    private static final int width = 32, height = 32;
		
		public static BufferedImage player, stopsign, star, gaps, angry, platform, water;
	
	public static void init(){ //this init method is whats going to load everthing in to my game
	    SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/EscapeSprites.png")); 	                                //only going to be used once to make the game more efficient
	
	    player = sheet.minimize(0, 0, width, height);
	    stopsign = sheet.minimize(width, 0, width, height);
	    star = sheet.minimize(width* 2, 0, width, height);
	    gaps = sheet.minimize(width*3, 0, width, height);
	    angry = sheet.minimize(0, height, width, height);
	    platform = sheet.minimize(width, height, width, height);
	    water = sheet.minimize(width*2, height, width, height);
	}

}
