package ua.training;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    // Resource Bundle Installation's
    static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    new Locale("ua", "UA"));  // Ukrainian
                    //new Locale("en"));// English

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessage(String template, String[] params) {
        System.out.println(makeFormattedString(template, params));
    }

    public String makeFormattedString(String template, String[] params) {
        return String.format(template, params);
    }

    public String makeFormattedString(String template, Integer[] params) {
        return String.format(template, params);
    }
}
