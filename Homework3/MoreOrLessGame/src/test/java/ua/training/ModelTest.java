package ua.training;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.fail;

public class ModelTest {
    public static Model model;

    @BeforeClass
    public static void init() {
        model = new Model();
    }

    @Test
    public void checkInBoundaries_50_is_True() {
        Assert.assertTrue(model.checkInBoundaries(50));
    }

    @Test
    public void checkInBoundaries_25_is_True() {
        Assert.assertTrue(model.checkInBoundaries(25));
    }

    @Test
    public void checkInBoundaries_125_is_False() {
        Assert.assertFalse(model.checkInBoundaries(125));
    }

    @Test
    public void checkInBoundaries_minus125_is_False() {
        Assert.assertFalse(model.checkInBoundaries(-125));
    }

    @Test
    public void checkInBoundaries_0_is_False() {
        Assert.assertFalse(model.checkInBoundaries(0));
    }

    @Test
    public void checkInBoundaries_100_is_False() {
        Assert.assertFalse(model.checkInBoundaries(100));
    }

    @Test
    public void checkInBoundaries_1_is_True() {
        Assert.assertTrue(model.checkInBoundaries(1));
    }

    @Test
    public void checkInBoundaries_99_is_True() {
        Assert.assertTrue(model.checkInBoundaries(99));
    }

    @Test
    public void generatePuzzledNumber_oneTime() {
        model.generatePuzzledNumber();
        int puzzledNumber = model.getPuzzledNumber();

        Assert.assertTrue(model.checkInBoundaries(puzzledNumber));
    }



}