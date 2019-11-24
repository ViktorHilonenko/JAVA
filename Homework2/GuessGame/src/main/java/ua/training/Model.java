package ua.training;

import java.util.Random;

public class Model {
    public int BOUND_MIN = 0;
    public int BOUND_MAX = 100;

    private int puzzledNumber;

    private int boundMin;
    private int boundMax;

    public Model() {
        boundMin = BOUND_MIN;
        boundMax = BOUND_MAX;

        generatePuzzledNumber();
    }

    public void generatePuzzledNumber() {
        Random rand = new Random();
        puzzledNumber = BOUND_MIN + rand.nextInt(BOUND_MAX - BOUND_MIN) + 1;
    }

    public byte nextApproach(int approachNumber) {
        byte res = 0;

        if(approachNumber < puzzledNumber) {
            res = -1;
            boundMin = approachNumber + 1;
        } else if(approachNumber > puzzledNumber) {
            res = 1;
            boundMax = approachNumber - 1;
        }

        return res;
    }

    public boolean checkInBoundaries(int approachNumber) {
        return (boundMin <= approachNumber && approachNumber <= boundMax);
    }

    public int getBoundMin() {
        return boundMin;
    }

    public int getBoundMax() {
        return boundMax;
    }
}
