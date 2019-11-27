package ua.training;

public class NoteBookRecordFieldString {
	public String value;
	public String regex;
	public boolean required;
	public boolean countable;

	public NoteBookRecordFieldString(String regex, boolean required, boolean countable) {
		this.regex = regex;
		this.required = required;
		this.countable = countable;
	}
}
