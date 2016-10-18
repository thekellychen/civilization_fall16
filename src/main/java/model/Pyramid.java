package model;

public class Pyramid extends Landmark {

    public Pyramid(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        super.invest();
        setPhilosophyGeneration(getPhilosophyGeneration() + 25);
    }

    @Override
    public String toString() {
        return "Pyramid. " + super.toString();
    }
}