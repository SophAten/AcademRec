package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.util.ArrayList;

import javafx.collections.FXCollections;

public class RecommendationController {
	private SharedDataModel sharedDataModel;

	@FXML
	private TextField dateTextField;
	@FXML
	private TextField firstTextField;
	@FXML
	private TextField lastNameField;
	@FXML
	private ChoiceBox<String> genderChoiceBox;
	@FXML
	private TextField targetSchoolTextField;
	@FXML
	private TextField firstSemesterYearTextField;
	@FXML
	private ListView<String> additionalCoursesListView;
	@FXML
	private ListView<String> personalCharacteristicsListView;
	@FXML
	private ListView<String> academicCharacteristicsListView;
	@FXML
	private ComboBox<String> firstCourseComboBox;
	@FXML
	private ComboBox<String> firstSemesterComboBox;
	@FXML
	private ChoiceBox<String> programChoiceBox;
	@FXML
	private Button compileButton;
	@FXML
	private Main main;
	@FXML
	private Button backButton;
	


	public RecommendationController(SharedDataModel sharedDataModel) {
		this.sharedDataModel = sharedDataModel;
		this.main = main;
	}
	public RecommendationController(Main main) {
		this.main = main;
	}

	@FXML
	public void initialize() {
		populateChoiceBoxes();
		compileButton.setOnAction(event -> onCompileButtonClicked());
		backButton.setOnAction(event -> handleBackButton());
	}

	private void populateChoiceBoxes() {
		genderChoiceBox.setItems(sharedDataModel.getGenderOptions());
		genderChoiceBox.getSelectionModel().select(0);

		firstSemesterComboBox.setItems(sharedDataModel.getSemesterOptions());
		firstSemesterComboBox.getSelectionModel().select(0);

		programChoiceBox.setItems(sharedDataModel.getProgramOptions());
		programChoiceBox.getSelectionModel().select(0);

		firstCourseComboBox.setItems(sharedDataModel.getCourseOptions());
		firstCourseComboBox.getSelectionModel().select(0);

		additionalCoursesListView
				.setItems(FXCollections.observableArrayList(sharedDataModel.getPersonalCharacterOptions()));
		additionalCoursesListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		personalCharacteristicsListView
				.setItems(FXCollections.observableArrayList(sharedDataModel.getPersonalCharacterOptions()));
		personalCharacteristicsListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		academicCharacteristicsListView
				.setItems(FXCollections.observableArrayList(sharedDataModel.getAcademicCharacterOptions()));
		academicCharacteristicsListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

	private void onCompileButtonClicked() {
		// Extract data from UI elements
		String date = dateTextField.getText().trim();
		String firstName = firstTextField.getText().trim();
		String lastName = lastNameField.getText().trim();
		String gender = genderChoiceBox.getValue();
		String targetSchool = targetSchoolTextField.getText().trim();
		// String firstSemesterYear = firstSemesterYearTextField.getText().trim();
		String firstCourse = firstCourseComboBox.getValue();
		String firstSemester = firstSemesterComboBox.getValue();
		String program = programChoiceBox.getValue();
		ObservableList<String> additionalCoursesList = additionalCoursesListView.getSelectionModel().getSelectedItems();
		ObservableList<String> personalCharacteristicsList = personalCharacteristicsListView.getSelectionModel()
				.getSelectedItems();
		ObservableList<String> academicCharacteristicsList = academicCharacteristicsListView.getSelectionModel()
				.getSelectedItems();

		// Create a Recommendation object
		Recommendation recommendation = new Recommendation(firstName, lastName, gender, date,
				/* faculty, */targetSchool, program, firstSemester, firstCourse,
				new ArrayList<String>(additionalCoursesList), new ArrayList<String>(personalCharacteristicsList),
				new ArrayList<String>(academicCharacteristicsList));

		// save the recommendation data to a file here
	}
	
	private void handleBackButton() {
	    try {
	        main.showMenuScene();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
