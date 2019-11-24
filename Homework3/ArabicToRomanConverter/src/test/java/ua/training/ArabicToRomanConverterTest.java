package ua.training;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArabicToRomanConverterTest {
    public static ArabicToRomanConverter arabicToRomanConverter;

    @BeforeClass
    public static void init() {
        arabicToRomanConverter = new ArabicToRomanConverter();
    }

    @Test
    public void convertArabicToRoman_arabic1_romanI() {
        Assert.assertEquals("I", arabicToRomanConverter.convertArabicToRoman(1));
    }
}