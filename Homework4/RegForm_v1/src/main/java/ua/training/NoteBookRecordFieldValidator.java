package ua.training;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class NoteBookRecordFieldValidator {

	public boolean allFieldsAreValid() {
		boolean res = true;

		for(Field nextField: getClass().getDeclaredFields()) {
			Object aFieldInstance;

			try {
				aFieldInstance = nextField.get(this);
			} catch (IllegalAccessException e) {
				System.out.println("Field "+nextField.getName()+" is not accessible!"); //TODO move to TextConstants
				continue;
			}

			if(nextField.getType().equals(NoteBookRecordFieldString.class)) {
				if(((NoteBookRecordFieldString) aFieldInstance).required && !((NoteBookRecordFieldString) aFieldInstance).countable) {
					if(((NoteBookRecordFieldString) aFieldInstance).value.isEmpty()) {
						res = false;
						//break;
					}
				}
			} else if(nextField.getType().equals(NoteBookGroupsEnum.class)) {
				if(aFieldInstance == null) {
					res = false;
					//break;
				}
			}
		}

		for(Field nextField: getClass().getDeclaredFields()) {
			Object aFieldInstance;

			try {
				aFieldInstance = nextField.get(this);
			} catch (IllegalAccessException e) {
				System.out.println("Field "+nextField.getName()+" is not accessible!"); //TODO move to TextConstants
				continue;
			}

			if(nextField.getType().equals(NoteBookRecordFieldString.class)) {
				if(!stringIsValid(((NoteBookRecordFieldString) aFieldInstance).value, ((NoteBookRecordFieldString) aFieldInstance).regex)) {
					((NoteBookRecordFieldString) aFieldInstance).value = null;
					res = false;
					//break;
				}
			} else if(nextField.getType().equals(NoteBookRecordFieldAddress.class)) {
				if(!((NoteBookRecordFieldAddress) aFieldInstance).allFieldsAreValid()) {
					res = false;
					//break;
				}
			} else if(nextField.getType().equals(NoteBookGroupsEnum.class)) {
				//якщо не нулл, то валідний
			}
		}

		return res;
	}

	private boolean stringIsValid(String value, String regex) {
		boolean res = false;

		if("".equals(regex)) {
			res = true;
		} else {
			String rgx = "^"+regex+"$";

			Pattern ptrn;

			try {
				ptrn = Pattern.compile(rgx);
			} catch (PatternSyntaxException e) {
				System.out.println("not valid regex: "+rgx);
				return res;
			}

			Matcher matcher = ptrn.matcher(value);
			res = matcher.matches();
		}

		return res;
	}

}
