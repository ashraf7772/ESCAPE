package escape.worlds;

import java.awt.Graphics;

import escape.Game;
import escape.functions.Functions;
import escape.tiles.Tile;

public class World {
	
	private Game game;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	public World(Game game,String path){
		this.game = game;
		loadWorld(path);
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
	
		int xStart = 0;
		int xEnd = 0;
		int yStart = 0;
		int yEnd = 0;
		
		
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - game.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT- game.getGameCamera().getyOffset()));
				
					}
			}
		
	}
	
	public Tile getTile(int x,int y){
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.platformTile;
		return t;
		
		
	}
	
	private void loadWorld(String path) {
		String file = Functions.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Functions.parseInt(tokens[0]);
		height = Functions.parseInt(tokens[1]);
		spawnX = Functions.parseInt(tokens[2]);
		spawnY = Functions.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++) {
				tiles[x][y] = Functions.parseInt(tokens[(x + y * width) + 4]);
					}
			}
	   }
}


