package calculation;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ArithmeticsTest {
    private static Arithmetics a;

    @BeforeClass
    public static void initArithmetics() {
        a = new Arithmetics();
    }

    @Test
    public void testAdd() {
        double expected = 4.0;
        double actual = a.add(2.0, 2.0);

        Assert.assertTrue(expected == actual);

//        if(actual != expected) {
//            fail("An error occured during testing of function add");
//        }
        //assertEquals(expected, actual);
    }

    @Test
    public void testSubtract() {

        double expected = 1.0;
        double actual = a.subtract(3.0, 2.0);

        //Assert.assertEquals(expected, actual);

        //Assert.assertTrue("Substraction doesn't work!!!", expected == actual);
        Assert.assertFalse("Substraction doesn't work!!!", expected != actual);
    }

    @Test
    public void testMultiply() {
        double expected = 6.0;
        double actual = a.multiply(2.0, 3.0);

        Assert.assertTrue(expected == actual);
    }

    @Test
    public void testDivide() {
        double expected = 2.0;
        double actual = a.divide(8.0, 4.0);

        Assert.assertTrue(expected == actual);
    }

    @Ignore
    @Test
    public void testOfDisablingTests() {
        double expected = 2.0;
        double actual = a.divide(8.0, 4.0);

        Assert.assertNull(actual);
    }

    @Test
    public void testDivideByZero() {
        Assert.assertThrows(ArithmeticException.class, () -> a.divide(8.0, 0.0));
    }

    @Test(timeout=1000)
    public void timeoutNotExceeded()
    {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout=10)
    public void timeoutExceeded()
    {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}