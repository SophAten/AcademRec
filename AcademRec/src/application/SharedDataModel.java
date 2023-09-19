package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SharedDataModel {
	private ObservableList<String> genderOptions = FXCollections.observableArrayList();
	private ObservableList<String> semesterOptions = FXCollections.observableArrayList();
	private ObservableList<String> programOptions = FXCollections.observableArrayList();
	private ObservableList<String> courseOptions = FXCollections.observableArrayList();
	private ObservableList<String> personalCharacterOptions = FXCollections.observableArrayList();
	private ObservableList<String> academicCharacterOptions = FXCollections.observableArrayList();

	public SharedDataModel() {
		genderOptions.addAll("Male", "Female", "Non-Binary", "Prefer not to say");
		// Initialize other options...
	}

	public ObservableList<String> getGenderOptions() {
		return genderOptions;
	}

	public ObservableList<String> getSemesterOptions() {
		return semesterOptions;
	}

	public ObservableList<String> getProgramOptions() {
		return programOptions;
	}

	public ObservableList<String> getCourseOptions() {
		return courseOptions;
	}

	public ObservableList<String> getPersonalCharacterOptions() {
		return personalCharacterOptions;
	}

	public ObservableList<String> getAcademicCharacterOptions() {
		return academicCharacterOptions;
	}

	// Added setter methods
	public void setGenderOptions(ObservableList<String> genderOptions) {
		this.genderOptions = genderOptions;
	}

	public void setSemesterOptions(ObservableList<String> semesterOptions) {
		this.semesterOptions = semesterOptions;
	}

	public void setProgramOptions(ObservableList<String> programOptions) {
		this.programOptions = programOptions;
	}

	public void setCourseOptions(ObservableList<String> courseOptions) {
		this.courseOptions = courseOptions;
	}

	public void setPersonalCharacterOptions(ObservableList<String> personalCharacterOptions) {
		this.personalCharacterOptions = personalCharacterOptions;
	}

	public void setAcademicCharacterOptions(ObservableList<String> academicCharacterOptions) {
		this.academicCharacterOptions = academicCharacterOptions;
	}
}
