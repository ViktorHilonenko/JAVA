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
    public void generatePuzzledNumber() {
        fail();
    }

    @Test
    public void checkInBoundaries_50_is_True() {
        Assert.assertTrue(model.checkInBoundaries(50));
    }
}