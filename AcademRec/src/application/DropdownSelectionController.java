package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DropdownSelectionController {
	private Main main;
	private SharedDataModel sharedDataModel;
	private Faculty faculty;

	private ArrayList<String> programOptions = new ArrayList<>();
	private ArrayList<String> personalCharacterOptions = new ArrayList<>();
	private ArrayList<String> academicCharacterOptions = new ArrayList<>();
	private ArrayList<String> courseOptions = new ArrayList<>();
	private ArrayList<String> semesterOptions = new ArrayList<>();

	@FXML
	private Button compileButton;
	@FXML
	private Button backButton;

	@FXML
	private ListView<String> programListView;
	@FXML
	private ListView<String> personalCharacteristicsListView;
	@FXML
	private ListView<String> academicCharacteristicsListView;
	@FXML
	private ListView<String> coursesListView;
	@FXML
	private ListView<String> semesterListView;

	@FXML
	private TextField programTextField;
	@FXML
	private TextField personalCharacteristicsTextField;
	@FXML
	private TextField academicCharacteristicsTextField;
	@FXML
	private TextField coursesTextField;
	@FXML
	private TextField semesterTextField;

	@FXML
	private TextField fullNameTextField;
	@FXML
	private TextField titleTextField;
	@FXML
	private TextField schoolTextField;
	@FXML
	private TextField departmentTextField;
	@FXML
	private TextField emailTextField;
	@FXML
	private TextField phoneNumberTextField;

	public void setMain(Main main) {
		this.main = main;
	}

	@FXML
	public void initialize() {
		// Set onCompileButtonClicked() method as an action for the compile button
		compileButton.setOnAction(event -> onCompileButtonClicked());

		backButton.setOnAction(event -> handleBackButton());

		// Load data from files
		loadDataFromFiles();

		// Set initial values of program options from ArrayList
		programListView.getItems().addAll(programOptions);

		// Set initial values of personal characteristics options from ArrayList
		personalCharacteristicsListView.getItems().addAll(personalCharacterOptions);

		// Set initial values of academic characteristics options from ArrayList
		academicCharacteristicsListView.getItems().addAll(academicCharacterOptions);

		// Set initial values of course options from ArrayList
		coursesListView.getItems().addAll(courseOptions);

		// Set initial values of semester options from ArrayList
		semesterListView.getItems().addAll(semesterOptions);
	}

	public DropdownSelectionController() {
	}

	// Update the constructor to receive the shared data model
	public DropdownSelectionController(Main main, SharedDataModel sharedDataModel) {
	    this.main = main;
	    this.sharedDataModel = sharedDataModel;
	}

	public void loadDataFromFiles() {
		try {
			// Load semester options from file
			File semesterFile = new File("semesterOptions.txt");
			Scanner semesterScanner = new Scanner(semesterFile);
			while (semesterScanner.hasNextLine()) {
				programOptions.add(semesterScanner.nextLine());
			}
			semesterScanner.close();

			// Load program options from file
			File programFile = new File("programOptions.txt");
			Scanner programScanner = new Scanner(programFile);
			while (programScanner.hasNextLine()) {
				programOptions.add(programScanner.nextLine());
			}
			programScanner.close();

			// Load personal characteristics options from file
			File personalFile = new File("personalCharacterOptions.txt");
			Scanner personalScanner = new Scanner(personalFile);
			while (personalScanner.hasNextLine()) {
				personalCharacterOptions.add(personalScanner.nextLine());
			}
			personalScanner.close();

			// Load academic characteristics options from file
			File academicFile = new File("academicCharacterOptions.txt");
			Scanner academicScanner = new Scanner(academicFile);
			while (academicScanner.hasNextLine()) {
				academicCharacterOptions.add(academicScanner.nextLine());
			}
			academicScanner.close();

			// Load course options from file
			File courseFile = new File("coursesOptions.txt");
			Scanner courseScanner = new Scanner(courseFile);
			while (courseScanner.hasNextLine()) {
				courseOptions.add(courseScanner.nextLine());
			}
			courseScanner.close();

			// Add loaded options to the corresponding list views
			programListView.getItems().addAll(programOptions);
			personalCharacteristicsListView.getItems().addAll(personalCharacterOptions);
			academicCharacteristicsListView.getItems().addAll(academicCharacterOptions);
			coursesListView.getItems().addAll(courseOptions);
			semesterListView.getItems().addAll(semesterOptions);

			// System.out.println(semesterOptions);
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error while reading file: " + e.getMessage());
		}
	}

	private void addItemToListView(TextField textField, ListView<String> listView) {
		String text = textField.getText().trim();
		if (!text.isEmpty()) {
			listView.getItems().add(text);
			textField.clear();
		}
	}

	private void onCompileButtonClicked() {
		// Save data from TextFields to ListViews
		addItemToListView(programTextField, programListView);
		addItemToListView(personalCharacteristicsTextField, personalCharacteristicsListView);
		addItemToListView(academicCharacteristicsTextField, academicCharacteristicsListView);
		addItemToListView(coursesTextField, coursesListView);
		addItemToListView(semesterTextField, semesterListView);

		if (faculty != null) {
			// Set the faculty signature values
			String fullName = fullNameTextField.getText();
			String[] nameParts = fullName.split(" ");
			if (nameParts.length >= 2) {
				faculty.setFirstName(nameParts[0]);
				faculty.setLastName(nameParts[1]);
			}
			faculty.setRole(titleTextField.getText());
			faculty.setSchool(schoolTextField.getText());
			faculty.setDepartment(departmentTextField.getText());
			faculty.setEmail(emailTextField.getText());
			faculty.setPhone(phoneNumberTextField.getText());
		}

		// Update shared data model with the new data
		sharedDataModel.setProgramOptions(programListView.getItems());
		sharedDataModel.setPersonalCharacterOptions(personalCharacteristicsListView.getItems());
		sharedDataModel.setAcademicCharacterOptions(academicCharacteristicsListView.getItems());
		sharedDataModel.setCourseOptions(coursesListView.getItems());
		sharedDataModel.setSemesterOptions(semesterListView.getItems());
	}

	private void handleBackButton() {
		try {
			main.showMenuScene();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
