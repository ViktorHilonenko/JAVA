package ua.training;

public class View {
    // Text's constants
    public static final String INPUT_TYPE = "Type exact word \"%s\" (or press Enter to interrupt):";
    public static final String RES_SENTENCE = "Congratulations! The result sentence is \"%s\"";
    public static final String IMPROPER_USE = "Improper use of method getResSentence!";
    public static final String GOOD_BYE = "Good bye!";
    public static final String INCORRECT_INPUT = "Your input is incorrect! Try again..."; //(!) its better move this to an interface

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printFormattedMessage(String template, String param) {
        System.out.println(String.format(template, param));
    }

}
