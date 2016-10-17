package model;

public class BlackPowderUnit extends SiegeUnit {
	
    public BlackPowderUnit(Civilization owner) {
    	super(owner);
    }

	@Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
    }

	@Override
    public void attack(MapObject o) {
        this.getOwner().getStrategy().siege();
        battle(o);
        setCanAttack(false);
    }

    @Override
    public char symbol() {
        return 'B';
    }

    @Override
    public String toString() {
        return "Black Powder Unit. " + super.toString();
    }
}