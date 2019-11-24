package ua.training;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    // Constructor
    private Model model;
    private View view;
    private ArrayList logList;

    private Scanner scannerInstance = null;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;

        this.logList = new ArrayList();
    }

    private Scanner getScannerInstance() {
        if (scannerInstance == null) {
            scannerInstance = new Scanner(System.in);
        }

        return scannerInstance;
    }

    // The Work method
    public void processUserInput() {
        this.view.printMessage(View.GREETING);
        nextUserInput();
    }

    private void nextUserInput() {
        Integer[] boundaries = new Integer[] {this.model.getBoundMin(), this.model.getBoundMax()};
        this.view.printFormattedMessage(View.RANGE, boundaries);
        this.view.printMessage(View.PROMPT);

        String userInput = "";

        while( true ) {
            Scanner sc = getScannerInstance();

            userInput = sc.nextLine();

            StringBuilder sbLog = new StringBuilder();

            if("".equals(userInput)) {
                this.view.printMessage(View.GOOD_BYE);
                return;
            } else {
                Integer userInputInt = this.model.getBoundMin() - 1;
                boolean numberIsOK = true;

                String[] strParams = new String[] {userInput};
                String userEntered = this.view.makeFormattedString(View.USER_ENTERED, strParams);
                this.view.printMessage(userEntered);
                sbLog.append(userEntered);

                try {
                    userInputInt = Integer.parseInt(userInput);
                } catch (NumberFormatException e) {
                    numberIsOK = false;
                    this.view.printMessage(View.INCORRECT_MUNBER);
                    sbLog.append(", ");
                    sbLog.append(View.I_RREPLIED);
                    sbLog.append(" ");
                    sbLog.append(View.INCORRECT_MUNBER);
                }

                if(numberIsOK) {
                    if(!this.model.checkInBoundaries(userInputInt)) {
                        numberIsOK = false;
                        this.view.printMessage(View.OUT_OF_BOUNDS);
                        sbLog.append(", ");
                        sbLog.append(View.I_RREPLIED);
                        sbLog.append(" ");
                        sbLog.append(View.OUT_OF_BOUNDS);
                    }
                }

                logList.add(sbLog.toString());

                if(numberIsOK) {
                    byte nextApproachRes = this.model.nextApproach(userInputInt);
                    if (nextApproachRes < 0) {
                        this.view.printMessage(View.GRATER);
                    } else if (nextApproachRes > 0) {
                        this.view.printMessage(View.LESS);
                    } else {
                        this.view.printMessage(View.CONGRATULATIONS);
                        this.view.printMessage(View.LOG_LIST);
                        for (Object aLogString : logList) {
                            System.out.println(aLogString);
                        }

                        System.exit(0); //(?) what's the best way to do that?
                    }
                }

                nextUserInput();
            }
        }
    }

}
