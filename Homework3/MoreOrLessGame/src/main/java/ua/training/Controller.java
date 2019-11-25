package ua.training;

import java.util.ArrayList;
import java.util.List;
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
        this.view.printMessage(TextConstants.GREETING);
        nextUserInput();
    }

    private void nextUserInput() {
        int userInput;

        while(true) {
            Integer[] boundaries = new Integer[] {this.model.getBoundMin(), this.model.getBoundMax()};
            this.view.printFormattedMessage(TextConstants.RANGE, boundaries);
            this.view.printMessage(TextConstants.PROMPT);

            Scanner sc = getScannerInstance();

            while (!sc.hasNextInt()) {
                view.printMessage(TextConstants.INCORRECT_INT_MUNBER);
                sc.next();
            }

            userInput = sc.nextInt();

            StringBuilder sbLog = new StringBuilder();

            String[] strParams = new String[] {Integer.toString(userInput)};
            String userEntered = this.view.makeFormattedString(TextConstants.USER_ENTERED, strParams);
            this.view.printMessage(userEntered);

            sbLog.append(userEntered);

            boolean numberIsOK = true;

            if(!this.model.checkInBoundaries(userInput)) {
                numberIsOK = false;
                this.view.printMessage(TextConstants.OUT_OF_BOUNDS);
                sbLog.append(", ");
                sbLog.append(TextConstants.I_RREPLIED);
                sbLog.append(" ");
                sbLog.append(TextConstants.OUT_OF_BOUNDS);
            }

            this.model.logList.add(sbLog.toString());

            if(numberIsOK) {
                if(userInput < this.model.getPuzzledNumber()) {
                    this.view.printMessage(TextConstants.GRATER);

                    this.model.setBoundMin(userInput + 1);
                } else if(userInput > this.model.getPuzzledNumber()) {
                    this.view.printMessage(TextConstants.LESS);

                    this.model.setBoundMax(userInput - 1);
                } else {
                    this.view.printMessage(TextConstants.CONGRATULATIONS);

                    this.view.printMessage(TextConstants.LOG_LIST);
                    for (Object aLogString : this.model.logList) {
                        System.out.println(aLogString);
                    }

                    break;
                }
            }
        }
    }

}
