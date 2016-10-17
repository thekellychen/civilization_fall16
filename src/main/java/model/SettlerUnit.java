package model;

public class SettlerUnit extends Unit implements Convertable {
	
	private String townName;

	public SettlerUnit(Civilization owner, String townName) {
		super(owner);
		this.townName = townName;
	}

	public String getTownName() {
		return this.townName;
	}

    @Override
	public Building convert() {
		getOwner().incrementNumSettlements();
		return getOwner().getSettlement(this.townName);
	}

    @Override
	public boolean canConvert(TileType type) {
        return type == TileType.PLAINS;
	}

	@Override
	public char symbol() {
		return 's';
	}

    @Override
    public String toString() {
        return "Settlers of " + this.townName + " . " + super.toString();
    }
}