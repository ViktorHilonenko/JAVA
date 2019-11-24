package ua.training;

import java.util.Scanner;

public class Controller {
    // Constructor
    private Model model;
    private View view;

    private Scanner scannerInstance = null;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    private Scanner getScannerInstance() {
        if (scannerInstance == null) {
            scannerInstance = new Scanner(System.in);
        }

        return scannerInstance;
    }

    // The Work method
    public void processUserInput() {
        this.model.setStrHello(inputExactStringValueWithScanner("Hello"));

        if("".equals(this.model.getStrHello())) {
            return;
        }

        this.model.setStrJava(inputExactStringValueWithScanner("Java!"));

        if("".equals(this.model.getStrJava())) {
            return;
        }

        this.view.printFormattedMessage(View.RES_SENTENCE, this.model.getResSentence());
    }

    // The Utility methods
    public String inputExactStringValueWithScanner(String exactString) {
        this.view.printFormattedMessage(View.INPUT_TYPE, exactString);

        String userInput = "";

        Boolean interruptedOrCorrectInput = false;

        while(!interruptedOrCorrectInput) {
            Scanner sc = getScannerInstance();

            userInput = sc.nextLine();

            if("".equals(userInput)) {
                interruptedOrCorrectInput = true;
                this.view.printMessage(View.GOOD_BYE);
            } else {
                if(exactString.equals(userInput)) {
                    interruptedOrCorrectInput = true;
                } else {
                    this.view.printMessage(View.INCORRECT_INPUT);
                }
            }

        }

        return userInput;
    }

}
