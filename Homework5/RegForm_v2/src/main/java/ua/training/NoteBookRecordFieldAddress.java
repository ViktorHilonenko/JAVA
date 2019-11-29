package ua.training;

public class NoteBookRecordFieldAddress extends NoteBookRecordFieldValidator {
	public NoteBookRecordFieldString zipCode = new NoteBookRecordFieldString("[0-9]{5}", true, false);
	public NoteBookRecordFieldString city = new NoteBookRecordFieldString("[A-Za-z0-9]{1,30}", true, false);
	public NoteBookRecordFieldString street = new NoteBookRecordFieldString("[A-Za-z0-9]{1,30}", true, false);
	public NoteBookRecordFieldString buildingNumber = new NoteBookRecordFieldString("[A-Za-z0-9]{1,10}", true, false);
	public NoteBookRecordFieldString flatNumber = new NoteBookRecordFieldString("[A-Za-z0-9]{1,10}", false, false);
	
	@Override
	public String toString() {
		String strFlatNumber = "";
		if(!flatNumber.value.isEmpty()) {
			strFlatNumber = ", flatNumber=" + flatNumber.value;
		} 

		return "Address [zipCode=" + zipCode.value + ", city=" + city.value + ", street=" + street.value + ", buildingNumber="
				+ buildingNumber.value + strFlatNumber + "]"; //TODO move to TextConstants
	}

}
