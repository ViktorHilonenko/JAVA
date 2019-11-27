package ua.training;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class NoteBookRecord extends NoteBookRecordFieldValidator {
	//TODO make regexes more strict, now it's first approach

	public NoteBookRecordFieldString lastName = new NoteBookRecordFieldString("[A-Za-z]{1,20}", true, false);
	public NoteBookRecordFieldString firstName = new NoteBookRecordFieldString("[A-Za-z]{1,20}", true, false);
	public NoteBookRecordFieldString middleName = new NoteBookRecordFieldString("[A-Za-z]{1,20}", true, false);
	public NoteBookRecordFieldString fullName = new NoteBookRecordFieldString("", true, true);
	public NoteBookRecordFieldString nickname = new NoteBookRecordFieldString("[A-Za-z0-9]{1,20}", true, false);
	public NoteBookRecordFieldString comment = new NoteBookRecordFieldString("", true, false);
	public NoteBookGroupsEnum noteBookGroup;
	public NoteBookRecordFieldString phoneNumberHome = new NoteBookRecordFieldString("[0-9]{10}", true, false);
	public NoteBookRecordFieldString phoneNumberCellular = new NoteBookRecordFieldString("[0-9]{10}", true, false);
	public NoteBookRecordFieldString phoneNumberCellular2 = new NoteBookRecordFieldString("[0-9]{10}", false, false);
	public NoteBookRecordFieldString email = new NoteBookRecordFieldString("[a-zA-Z0-9]@[a-zA-Z0-9]", true, false);
	public NoteBookRecordFieldString skype = new NoteBookRecordFieldString("[a-zA-Z][a-zA-Z0-9]{5,31}", true, false);
	public NoteBookRecordFieldAddress address;
	public String fullAddress;
	public LocalDate dateAdded;
	public LocalDate dateChanged;

	public void updateFullName() {
		StringBuffer sb = new StringBuffer();
		sb.append(lastName.value);
		sb.append(" ");
		sb.append(firstName.value.substring(0, 1));
		sb.append(".");

		fullName.value = sb.toString();
	}

	public NoteBookEntity toNoteBookEntity() {
		NoteBookEntity noteBookEntity = new NoteBookEntity();

		for(Field nextField: getClass().getDeclaredFields()) {
			Field noteBookEntityField;

			try {
				noteBookEntityField = NoteBookEntity.class.getDeclaredField(nextField.getName());
			} catch (NoSuchFieldException e) {
				continue;
			}

			Object aFieldInstance;

			try {
				aFieldInstance = nextField.get(this);
			} catch (IllegalAccessException e) {
				System.out.println("Field "+nextField.getName()+" is not accessible!"); //TODO move to TextConstants
				continue;
			}

			Object value;

			if(nextField.getType().equals(NoteBookRecordFieldString.class)) {
				value = ((NoteBookRecordFieldString) aFieldInstance).value;
			} else {
				value = aFieldInstance;
			}

			try {
				noteBookEntityField.set(noteBookEntity, value);
			} catch (IllegalAccessException e) {
				System.out.println("Field "+noteBookEntityField.getName()+" is not accessible!"); //TODO move to TextConstants
			}
		}

		return noteBookEntity;
	}
}
