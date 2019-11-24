package ua.training;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.fail;

public class ModelTest {
    @Test
    public void generatePuzzledNumber() {
        //that was not in TDD, had not enough time between courses and work...
        fail();
    }

    @Test
    public void nextApproach() {
        //that was not in TDD, had not enough time between courses and work...
        fail();
    }

    @Test
    public void checkInBoundaries() {
        Model model = new Model();
        Assert.assertTrue(model.checkInBoundaries(50));
    }
}