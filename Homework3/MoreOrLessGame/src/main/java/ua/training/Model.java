package ua.training;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    public int BOUND_MIN = 0;
    public int BOUND_MAX = 100;

    private int puzzledNumber;
    public ArrayList logList;

    private int boundMin;
    private int boundMax;

    public Model() {
        boundMin = BOUND_MIN + 1;
        boundMax = BOUND_MAX - 1;

        generatePuzzledNumber();

        this.logList = new ArrayList();
    }

    public void generatePuzzledNumber() {
        puzzledNumber = 0;
    }

    public int getPuzzledNumber() {
        return puzzledNumber;
    }

    public boolean checkInBoundaries(int approachNumber) {
        return ((boundMin <= approachNumber) && (approachNumber <= boundMax));
    }

    public int getBoundMin() {
        return boundMin;
    }

    public void setBoundMin(int newValue) {
        boundMin = newValue;
    }

    public int getBoundMax() {
        return boundMax;
    }

    public void setBoundMax(int newValue) {
        boundMax = newValue;
    }

}
