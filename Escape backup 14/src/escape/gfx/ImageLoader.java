package escape.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static BufferedImage LoadImage(String path){
		try {
			return ImageIO.read(ImageLoader.class.getResource(path)); // from the path u built within resources and textures
		} catch (IOException e) {
			e.printStackTrace(); //surrounded with a try and catch statement in case of errors
			System.exit(1);
		}
	    return null; // this is used just in case there are any errors 
	}

}
