package escape.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//static stuff here
	
	public static Tile [] tiles = new Tile[256];
	public static Tile platformTile = new PlatformTile(0);
	public static Tile waterTile = new WaterTile(1);
	public static Tile gapsTile = new GapsTile(2);
	//class
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected int id;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;this.id = id;
		this.id = id;
		
		tiles[id] = this;
		
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isStable(){
		return false;
	}
	
	public int getid() {
		return id;
	}
}
