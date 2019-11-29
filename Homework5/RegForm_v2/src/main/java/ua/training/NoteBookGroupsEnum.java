package ua.training;

public enum NoteBookGroupsEnum {
	FAMILY("Сім'я"),
	FRIENDS("Друзі"),
	COLLEAGUES("Колеги");
	
	private String title;
	
	NoteBookGroupsEnum(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}
