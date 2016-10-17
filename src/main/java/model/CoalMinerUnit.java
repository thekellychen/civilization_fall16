package model;

public class CoalMinerUnit extends Unit implements Convertable {
	
	public CoalMinerUnit(Civilization owner) {
		super(owner);
	}

    @Override
	public Building convert() {
        return getOwner().getCoalMine();
	}

    @Override
	public boolean canConvert(TileType type) {
        return type == TileType.HILLS;
	}

	@Override
	public char symbol() {
		return 'c';
	}

	@Override
    public String toString() {
        return "Coal Miners. " + super.toString();
    }
}