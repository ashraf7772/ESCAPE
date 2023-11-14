package escape.states;

import java.awt.Graphics;

import escape.Game;
import escape.entities.escapees.Player;
import escape.gfx.Parts;
import escape.tiles.Tile;
import escape.worlds.World;
                                                           
public class GameState extends State {                   
	
	private Player player;
	private World world;
	
	public GameState(Game game){
		super(game);              //where the player will be spawned into the game
		player = new Player(game, 32, 128);
		world = new World(game, "res/worlds/world1.txt");
		
		game.getGameCamera().move(0, 0);
	}
	
	@Override
	public void tick() {
		player.tick();
		game.getGameCamera().move(3, 0);
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
		//Tile.tiles[0].render(g, 0, 0);
		//Tile.tiles[1].render(g, 0, 0);
	}

}
