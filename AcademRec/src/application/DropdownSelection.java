package application;

public class DropdownSelection {
	public String courseName;
	public String semesters;
	public String personalChar;
	public String academicChar;
	public String program;

	public void editSelection(String courseName, String semesters, String personalChar, String academicChar,
			String program) {
		this.courseName = courseName;
		this.semesters = semesters;
		this.personalChar = personalChar;
		this.academicChar = academicChar;
		this.program = program;
	}

	/*
	 * public void deleteSelection() { // possible that this is not going to be
	 * implemented here // we might not need this at all // pierce }
	 */
}
