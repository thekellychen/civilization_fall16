package model;

public class GreatWall extends Landmark {
	
	public GreatWall(Civilization owner) {
		super(owner);
	}

	@Override
	public void invest() {
		super.invest();
		getOwner().getStrategy().battle(); //trying to call battle() in Strategy.java
	}

	@Override
    public String toString() {
        return "Great Wall. " + super.toString();
    }
}