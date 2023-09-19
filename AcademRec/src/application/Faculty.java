package application;

import java.util.StringJoiner;

public class Faculty extends People {
	public String role;
	public String department;
	public String school;
	public String email;
	public String phone;

	public Faculty(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public Faculty(String firstName, String lastName, String role, String school, String department, String email,
			String phone) {
		super(firstName, lastName);
		this.role = role;
		this.school = school;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}

	public String getSignature() {
		return String.format("%s %s\n%s\n%s\n%s\nEmail: %s\nPhone: %s", getFirstName(), getLastName(), role, department,
				school, email, phone);
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public String getDepartment() {
		return department;
	}

	public String getSchool() {
		return school;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String serialize() {
		StringJoiner joiner = new StringJoiner(",");
		joiner.add(escapeCommas(getFirstName()));
		joiner.add(escapeCommas(getLastName()));
		joiner.add(escapeCommas(role));
		joiner.add(escapeCommas(school));
		joiner.add(escapeCommas(department));
		joiner.add(escapeCommas(email));
		joiner.add(escapeCommas(phone));
		return joiner.toString();
	}

	public static Faculty deserialize(String data) {
		String[] parts = data.split(",", -1);
		String firstName = unescapeCommas(parts[0]);
		String lastName = unescapeCommas(parts[1]);
		String role = unescapeCommas(parts[2]);
		String school = unescapeCommas(parts[3]);
		String department = unescapeCommas(parts[4]);
		String email = unescapeCommas(parts[5]);
		String phone = unescapeCommas(parts[6]);
		return new Faculty(firstName, lastName, role, school, department, email, phone);
	}

	private static String escapeCommas(String input) {
		return input.replace(",", "\\,");
	}

	private static String unescapeCommas(String input) {
		return input.replace("\\,", ",");
	}

}