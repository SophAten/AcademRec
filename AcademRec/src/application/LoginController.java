package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
	Button login;
	@FXML
	Label wrongLogin;
	@FXML
	TextField passwordField;

	private Main main;
	private int loginCounter = 0;

	public LoginController(Main main) {
		this.main = main;
	}

	public void userLogin(ActionEvent event) throws IOException {
		checkLogin();
	}

	public void checkLogin() throws IOException {
		try {
			File pFile = new File("src/password.txt");
			boolean grantAccess = false;
			String enteredPassword = passwordField.getText();
			BufferedReader reader = new BufferedReader(new FileReader(pFile));
			String storedPassword = reader.readLine();
			reader.close();
			if (storedPassword.equals(enteredPassword)) {
				grantAccess = true;
			}
			try {
	            if (grantAccess) {
	                if (enteredPassword.equals("p")) {
	                    main.showChangePasswordScene();
	                } else {
	                    main.showMenuScene();
	                }
	            } else {
	                wrongLogin.setText("Wrong Password.");
	            }
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
