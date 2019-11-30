package ua.training;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * This is a Javadoc
 * Right now I don't have enough time to describe all this modules, but still have to try to work with JavaDoc)
 * hope see you soon
 */

public class Controller {
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

    // Interaction
    public void processUserInput() {
        this.view.printMessage(view.bundle.getString(TextConstants.GREETING));
        
        NoteBookRecord noteBookRecord = new NoteBookRecord();
        
        userFillRecordFields(noteBookRecord);

        if(noteBookRecord.allFieldsAreValid()) {
            noteBookRecord.updateFullName();
            noteBookRecord.fullAddress = noteBookRecord.address.toString();
            noteBookRecord.dateAdded = LocalDate.now();
            noteBookRecord.dateChanged = noteBookRecord.dateAdded;

            NoteBookEntity noteBookEntity = noteBookRecord.toNoteBookEntity();

            this.model.setNoteBookEntity(noteBookEntity);
        } else {
            view.printMessage(view.bundle.getString(TextConstants.SOMETHING_IS_NOT_VALID));
        }
    }

	private void userFillRecordFields(NoteBookRecord aRecord) {
        for(Field nextField: aRecord.getClass().getDeclaredFields()) {
        	if(nextField.getType().equals(NoteBookRecordFieldString.class)) {
        	    inputNoteBookRecordStringField(aRecord, nextField);
        	} else if(nextField.getType().equals(NoteBookRecordFieldAddress.class)) {
        	    aRecord.address = new NoteBookRecordFieldAddress();
                userFillRecordFields(aRecord.address);
        	} else if(nextField.getType().equals(NoteBookGroupsEnum.class)) {
                inputNoteBookGroupsEnum(aRecord, nextField);
        	}
        }
	}

    private void userFillRecordFields(NoteBookRecordFieldAddress aRecord) {
        for(Field nextField: aRecord.getClass().getDeclaredFields()) {
            if(nextField.getType().equals(NoteBookRecordFieldString.class)) {
                inputNoteBookRecordStringField(aRecord, nextField);
            }
        }
    }

    private void inputNoteBookRecordStringField(Object aRecord, Field nextField) {
        Object aFieldInstance;

        try {
            aFieldInstance = nextField.get(aRecord);
        } catch (IllegalAccessException e) {
            System.out.println("Field "+nextField.getName()+" is not accessible!"); //TODO move to TextConstants
            return;
        }

        if(((NoteBookRecordFieldString) aFieldInstance).countable) {
            //we don't ask user to fill countable fields
            return;
        }

        String requiredSign = "";
        if(((NoteBookRecordFieldString) aFieldInstance).required) {
            requiredSign = view.bundle.getString(TextConstants.REQUIRED_SIGN);
        }

        String[] strParams = new String[] {nextField.getName(), ((NoteBookRecordFieldString) aFieldInstance).regex, requiredSign};
        this.view.printMessage(view.bundle.getString(TextConstants.PROMPT_FIELD), strParams);

        if(!nextField.isAccessible()) {
            nextField.setAccessible(true);
        }

        Scanner sc = getScannerInstance();

        if(sc.hasNextLine()) {
            ((NoteBookRecordFieldString) aFieldInstance).value = sc.nextLine();
        }
    }

    private void inputNoteBookGroupsEnum(NoteBookRecord aRecord, Field nextField) {
        //(!) consider always required
        String requiredSign = view.bundle.getString(TextConstants.REQUIRED_SIGN);

        StringJoiner sjENUMS = new StringJoiner(", ", "[", "]");
        for(NoteBookGroupsEnum anENUM : NoteBookGroupsEnum.values()) {
            sjENUMS.add(anENUM.toString());
        }

        String[] strParams = new String[] {nextField.getName(), sjENUMS.toString(), requiredSign};
        this.view.printMessage(view.bundle.getString(TextConstants.PROMPT_ENUM_FIELD), strParams);

        if(!nextField.isAccessible()) {
            nextField.setAccessible(true);
        }

        Scanner sc = getScannerInstance();

        if(sc.hasNextLine()) {
            String userInput = sc.nextLine();

            NoteBookGroupsEnum noteBookGroupsEnum;

            try {
                noteBookGroupsEnum = NoteBookGroupsEnum.valueOf(userInput);
            } catch (IllegalArgumentException e) {
                //System.out.println("Value "+userInput+" is illegal!"); //TODO move to TextConstants
                return;
            }

            try {
                nextField.set(aRecord, noteBookGroupsEnum);
            } catch (IllegalAccessException e) {
                System.out.println("Field "+nextField.getName()+" is not accessible!"); //TODO move to TextConstants
            }
        }
    }

}
