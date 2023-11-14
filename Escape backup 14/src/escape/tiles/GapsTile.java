package escape.tiles;

import escape.gfx.Parts;

public class GapsTile extends Tile {

	public GapsTile (int id) {
		super(Parts.gaps, id);
	
	}
	@Override
	public boolean isStable() {
		return true;
	}

}
