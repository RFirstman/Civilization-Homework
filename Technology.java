public class Technology {
    private boolean foundMeaningOfLife = false;
    private boolean builtWonderOfTheWorld = false;
    private int understanding = 0;
    private int experienceLevel = 0;

    public void Philosophize() {
        understanding += 25;
        foundMeaningOfLife();
    }

    public void improveWriting() {
        understanding += 10;
        foundMeaningOfLife();
    }

    //Method to check if foundMeaningOfLife should be set to true
    public void checkMeaning() {
        if (understanding > 200) {
            foundMeaningOfLife = true;
        }
    }

    public increaseExperience(int experience) {
        experienceLevel += experience;
    }

    public void checkExperience() {
        if (experienceLevel > 200) {
            builtWonderOfTheWorld = true;
        }
    }
}