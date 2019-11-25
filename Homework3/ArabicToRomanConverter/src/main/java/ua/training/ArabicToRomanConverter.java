package ua.training;

import java.util.LinkedHashMap;
import java.util.Map;

public class ArabicToRomanConverter {

    public String convertArabicToRoman(int arabic) {
        LinkedHashMap<Integer, String> arabicRomanMap = new LinkedHashMap<Integer, String>();
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
