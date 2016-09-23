public class Technology {
    private int understanding;
    private boolean foundMeaningOfLife;
    private int experienceLevel;
    private boolean builtWonderOfTheWorld;

    //Philosophy
    public Technology() {
        this.understanding = 0;
        this.foundMeaningOfLife = false;
        this.experienceLevel = 0;
        this.builtWonderOfTheWorld = false;
    }
    public int getUnderstanding() {
        return this.understanding;
    }

    public void philosophize() {
        understanding += 25;
        if (understanding > 200) {
            foundMeaningOfLife = true;
        }
    }

    public void improveWriting() {
        understanding += 10;
        if (understanding > 200) {
            foundMeaningOfLife = true;
        }
    }

    //Architecture
    public void increaseExperience(int amtIncrease) {
        experienceLevel += amtIncrease;
        if (experienceLevel > 200) {
            builtWonderOfTheWorld = true;
        }
    }

    public int getBuildExperience() {
        return this.experienceLevel;
    }

    public boolean hasTechnologyWin() {
        return (foundMeaningOfLife && builtWonderOfTheWorld);
    }
}