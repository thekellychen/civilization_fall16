package model;

public class AnglerUnit extends Unit implements Convertable {
	
	public AnglerUnit(Civilization owner) {
		super(owner);
	}

    @Override
	public Building convert() {
        return getOwner().getFishingShack();
	}
    
    @Override
	public boolean canConvert(TileType type) {
        return type == TileType.WATER;
	}

	@Override
	public char symbol() {
		return 'a';
	}

	@Override
    public String toString() {
        return "Anglers. " + super.toString();
    }
}