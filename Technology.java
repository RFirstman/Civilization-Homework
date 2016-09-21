public class Technology {
    private boolean foundMeaningOfLife;
    private boolean builtWonderOfTheWorld;
    private int understanding;
    private int experienceLevel;

    public Technology() {
        foundMeaningOfLife = false;
        builtWonderOfTheWorld = false;
        understanding = 0;
        experienceLevel = 0;
    }

    public int getUnderstanding() {
        return understanding;
    }

    public int getBuildExperience() {
        return experienceLevel;
    }

    public void philosophize() {
        understanding += 25;
        checkCondition();
    }

    public void improveWriting() {
        understanding += 10;
        checkCondition();
    }

    public increaseExperience(int experience) {
        experienceLevel += experience;
    }

    //Checks if experienceLevel and foundMeaningOfLife are over 200 and sets
    //the appropriate boolean
    private checkCondition() {
        if (understanding > 200) {
            foundMeaningOfLife = true;
        }
        if (experienceLevel > 200) {
            builtWonderOfTheWorld = true;
        }

    }

    //Returns true if Technology win condition is reached
    public boolean hasTechnologyWin() {
        if (foundMeaningOfLife() && builtWonderOfTheWorld) {
            return true;
        }
    }
}