package application;

import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
import java.util.ArrayList;

public class Recommendation {
	// private Student student;
	private String firstName;
	private String lastName;
	private String gender;
	// private Faculty faculty;
	private String targetSchool;
	private String todayDate;
	private String program;
	private String firstSemester;
	private String firstCourse;
	private List<String> coursesTaken;
	private List<String> personalCharacteristics;
	private List<String> academicCharacteristics;
	// private String semester;
	// private String year;

	public Recommendation(String firstName, String lastName, String gender, String todayDate,
			/* Faculty faculty, */ String targetSchool, String program, String firstSemester, String firstCourse,
			ArrayList<String> coursesTaken, ArrayList<String> personalCharacteristics,
			ArrayList<String> academicCharacteristics) {
		// this.student = student;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.todayDate = todayDate;
		// this.faculty = faculty;
		this.targetSchool = targetSchool;
		this.program = program;
		this.firstSemester = firstSemester;
		this.firstCourse = firstCourse;
		this.coursesTaken = coursesTaken;
		this.personalCharacteristics = personalCharacteristics;
		this.academicCharacteristics = academicCharacteristics;
	}

	/*
	 * public Student getStudent() { return student; }
	 * 
	 * public void setStudent(Student student) { this.student = student; }
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/*
	 * public void setFaculty(Faculty faculty) { this.faculty = faculty; }
	 */
	public void setTargetSchool(String targetSchool) {
		this.targetSchool = targetSchool;
	}

	public void setTodayDate(String todayDate) {
		this.todayDate = todayDate;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public void setFirstSemester(String firstSemester) {
		this.firstSemester = firstSemester;
	}

	public void setFirstCourse(String firstCourse) {
		this.firstCourse = firstCourse;
	}

	public void setCoursesTaken(List<String> coursesTaken) {
		this.coursesTaken = coursesTaken;
	}

	public void setPersonalCharacteristics(List<String> personalCharacteristics) {
		this.personalCharacteristics = personalCharacteristics;
	}

	public void setAcademicCharacteristics(List<String> academicCharacteristics) {
		this.academicCharacteristics = academicCharacteristics;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	/*
	 * public Faculty getFaculty() { return faculty; }
	 */
	public String getTargetSchool() {
		return targetSchool;
	}

	public String getTodayDate() {
		return todayDate;
	}

	public String getProgram() {
		return program;
	}

	public String getFirstSemester() {
		return firstSemester;
	}

	public String getFirstCourse() {
		return firstCourse;
	}

	public List<String> getCoursesTaken() {
		return coursesTaken;
	}

	public List<String> getPersonalCharacteristics() {
		return personalCharacteristics;
	}

	public List<String> getAcademicCharacteristics() {
		return academicCharacteristics;
	}

	public String serialize() {
		StringJoiner joiner = new StringJoiner(",");
		joiner.add(String.valueOf(firstName));
		joiner.add(String.valueOf(lastName));
		joiner.add(String.valueOf(gender));
		// joiner.add(faculty.serialize());
		joiner.add(escapeCommas(targetSchool));
		joiner.add(escapeCommas(todayDate));
		joiner.add(escapeCommas(program));
		joiner.add(escapeCommas(firstSemester));
		joiner.add(String.valueOf(firstCourse));
		joiner.add(serializeList(coursesTaken));
		joiner.add(serializeList(personalCharacteristics));
		joiner.add(serializeList(academicCharacteristics));
		return joiner.toString();
	}

	public static Recommendation deserialize(String data) {
		String[] parts = data.split(",", -1);
		String firstName = unescapeCommas(parts[0]);
		String lastName = unescapeCommas(parts[1]);
		String gender = unescapeCommas(parts[2]);
		// Faculty faculty = Faculty.deserialize(parts[3]);
		String targetSchool = unescapeCommas(parts[4]);
		String todayDate = unescapeCommas(parts[5]);
		String program = unescapeCommas(parts[6]);
		String firstSemester = unescapeCommas(parts[7]);
		String firstCourse = unescapeCommas(parts[8]);
		ArrayList<String> coursesTaken = deserializeList(parts[9]);
		ArrayList<String> personalCharacteristics = deserializeList(parts[10]);
		ArrayList<String> academicCharacteristics = deserializeList(parts[11]);
		return new Recommendation(firstName, lastName, gender, todayDate, /* faculty, */ targetSchool, program,
				firstSemester, firstCourse, coursesTaken, personalCharacteristics, academicCharacteristics);
	}

	private String escapeCommas(String input) {
		return input.replace(",", "\\,");
	}

	private static String unescapeCommas(String input) {
		return input.replace("\\,", ",");
	}

	private String serializeList(List<String> list) {
		StringJoiner joiner = new StringJoiner(";");
		for (String item : list) {
			joiner.add(escapeCommas(item));
		}
		return joiner.toString();
	}

	private static ArrayList<String> deserializeList(String data) {
		String[] parts = data.split(";", -1);
		ArrayList<String> list = new ArrayList<>();
		for (String part : parts) {
			list.add(unescapeCommas(part));
		}
		return list;
	}
}