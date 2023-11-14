package escape.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet){
    	this.sheet = sheet;

    }
    
    public BufferedImage minimize(int x, int y, int width, int height){ //this methods purpose is to basically select specific sprites from my sprite sheets by minimizing into a specific area
       return sheet.getSubimage(x, y, width, height); //this line of code returns a sub image of our sprite sheet
    }
    
}
