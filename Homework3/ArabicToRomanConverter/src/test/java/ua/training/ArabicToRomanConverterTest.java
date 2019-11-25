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

    @Test
    public void convertArabicToRoman_arabic2_romanII() {
        Assert.assertEquals("II", arabicToRomanConverter.convertArabicToRoman(2));
    }

    @Test
    public void convertArabicToRoman_arabic3_romanIII() {
        Assert.assertEquals("III", arabicToRomanConverter.convertArabicToRoman(3));
    }

    @Test
    public void convertArabicToRoman_arabic4_romanIV() {
        Assert.assertEquals("IV", arabicToRomanConverter.convertArabicToRoman(4));
    }

    @Test
    public void convertArabicToRoman_arabic0_roman_() {
        Assert.assertEquals("", arabicToRomanConverter.convertArabicToRoman(0));
    }

    @Test
    public void convertArabicToRoman_arabic5_romanV() {
        Assert.assertEquals("V", arabicToRomanConverter.convertArabicToRoman(5));
    }

    @Test
    public void convertArabicToRoman_arabic6_romanVI() {
        Assert.assertEquals("VI", arabicToRomanConverter.convertArabicToRoman(6));
    }

    @Test
    public void convertArabicToRoman_arabic7_romanVII() {
        Assert.assertEquals("VII", arabicToRomanConverter.convertArabicToRoman(7));
    }

    @Test
    public void convertArabicToRoman_arabic8_romanVIII() {
        Assert.assertEquals("VIII", arabicToRomanConverter.convertArabicToRoman(8));
    }

    @Test
    public void convertArabicToRoman_arabic9_romanIX() {
        Assert.assertEquals("IX", arabicToRomanConverter.convertArabicToRoman(9));
    }

    @Test
    public void convertArabicToRoman_arabic10_romanX() {
        Assert.assertEquals("X", arabicToRomanConverter.convertArabicToRoman(10));
    }

    @Test
    public void convertArabicToRoman_arabic11_romanXI() {
        Assert.assertEquals("XI", arabicToRomanConverter.convertArabicToRoman(11));
    }

    @Test
    public void convertArabicToRoman_arabic12_romanXII() {
        Assert.assertEquals("XII", arabicToRomanConverter.convertArabicToRoman(12));
    }

    @Test
    public void convertArabicToRoman_arabic14_romanXIV() {
        Assert.assertEquals("XIV", arabicToRomanConverter.convertArabicToRoman(14));
    }

    @Test
    public void convertArabicToRoman_arabic15_romanXV() {
        Assert.assertEquals("XV", arabicToRomanConverter.convertArabicToRoman(15));
    }

}