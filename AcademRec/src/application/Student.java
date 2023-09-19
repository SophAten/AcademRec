package application;

import java.util.StringJoiner;

public class Student extends People {
	public String program;
	public String targetSchool;
	public String currentDate;
	public String semester;
	public String semesterYear;
	public String firstCourse;
	public String courseName;
	public String letterGrade;
	public String personalChar;
	public String academicChar;

	public Student(String firstName, String lastName) {
		super(firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	public String getStudentInfo() {
		return "";// FIX ME
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public void setTargetSchool(String targetSchool) {
		this.targetSchool = targetSchool;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public void setSemesterYear(String semesterYear) {
		this.semesterYear = semesterYear;
	}

	public void setFirstCourse(String firstCourse) {
		this.firstCourse = firstCourse;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}

	public void setPersonalChar(String personalChar) {
		this.personalChar = personalChar;
	}

	public void setAcademicChar(String academicChar) {
		this.academicChar = academicChar;
	}

	public String serialize() {// FIX
		StringJoiner joiner = new StringJoiner(",");
		joiner.add(escapeCommas(getFirstName()));
		joiner.add(escapeCommas(getLastName()));
		joiner.add(escapeCommas(program));
		joiner.add(escapeCommas(targetSchool));
		joiner.add(escapeCommas(program));
		joiner.add(escapeCommas(program));
		joiner.add(escapeCommas(program));

		return joiner.toString();
	}

	public static Student deserialize(String data) {
		String[] parts = data.split(",", -1);
		String firstName = unescapeCommas(parts[0]);
		String lastName = unescapeCommas(parts[1]);
		// Extract other attributes as needed
		return new Student(firstName, lastName);
	}

	private String escapeCommas(String input) {
		return input.replace(",", "\\,");
	}

	private static String unescapeCommas(String input) {
		return input.replace("\\,", ",");
	}

}