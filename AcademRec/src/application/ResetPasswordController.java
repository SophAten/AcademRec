package application;

import java.io.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ResetPasswordController {
	
	@FXML Button changePass;
	@FXML Label wrongPass;
	@FXML PasswordField passwordField;
	@FXML PasswordField checkPassword;
	
    private Main main;

    public ResetPasswordController(Main main) {
        this.main = main;
    }

	public void resetPassword(ActionEvent event) throws IOException{
		createPassword();
	}
	
	
	public void createPassword() throws IOException{
		try {
			
			String newPassword = passwordField.getText();
			String confirmPassword = checkPassword.getText();
			
			if(confirmPassword.equals(newPassword)) {
				File pFile = new File("src/password.txt");
				FileWriter pWriter = new FileWriter(pFile, false);
				pWriter.write(newPassword);
				pWriter.close();
				try {
					main.showLoginScene();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				wrongPass.setText("Passwords don't match.");

			}
		} catch(IOException e) {
			System.out.println("An error occurred while writing to the file: " + e.getMessage());
			e.printStackTrace();
		}
	}
}