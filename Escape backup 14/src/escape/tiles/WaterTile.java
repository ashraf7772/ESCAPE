package escape.tiles;

import escape.gfx.Parts;

public class WaterTile extends Tile {

	public WaterTile(int id) {
		super(Parts.water, id);
	}
	
	@Override
	public boolean isStable(){
		return true;
		
	}

}
