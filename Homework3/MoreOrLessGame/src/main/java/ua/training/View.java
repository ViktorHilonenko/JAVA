package ua.training;

public class View {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public String makeFormattedString(String template, String[] params) {
        return String.format(template, params);
    }

    public String makeFormattedString(String template, Integer[] params) {
        return String.format(template, params);
    }

    public void printFormattedMessage(String template, Integer[] params) {
        System.out.println(makeFormattedString(template, params));
    }

}
