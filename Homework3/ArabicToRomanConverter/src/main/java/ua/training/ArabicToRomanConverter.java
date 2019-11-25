package ua.training;

public class ArabicToRomanConverter {

    public String convertArabicToRoman(int arabic) {
        StringBuilder roman = new StringBuilder();

        while (arabic >= 1) {
            roman.append("I");
            arabic -= 1;
        }

        return roman.toString();
    }

}
