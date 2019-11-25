package ua.training;

import java.util.LinkedHashMap;
import java.util.Map;

public class ArabicToRomanConverter {

    public String convertArabicToRoman(int arabic) {
        LinkedHashMap<Integer, String> arabicRomanMap = new LinkedHashMap<Integer, String>();
        arabicRomanMap.put(1000, "M");
        arabicRomanMap.put(900, "CM");
        arabicRomanMap.put(500, "D");
        arabicRomanMap.put(400, "CD");
        arabicRomanMap.put(100, "C");
        arabicRomanMap.put(90, "XC");
        arabicRomanMap.put(50, "L");
        arabicRomanMap.put(40, "XL");
        arabicRomanMap.put(10, "X");
        arabicRomanMap.put(9, "IX");
        arabicRomanMap.put(5, "V");
        arabicRomanMap.put(4, "IV");
        arabicRomanMap.put(1, "I");

        StringBuilder roman = new StringBuilder();

        for(Map.Entry<Integer, String> arabicRomanEntry: arabicRomanMap.entrySet()) {
            while (arabic >= arabicRomanEntry.getKey()) {
                roman.append(arabicRomanEntry.getValue());
                arabic -= arabicRomanEntry.getKey();
            }
        }

        return roman.toString();
    }

}
