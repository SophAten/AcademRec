package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {
    private Main main;

    @FXML
    private Button createRecommendationButton;

    @FXML
    private Button editSelectionsButton;
    
    @FXML
    private Button logoutButton;

    public MenuController(Main main) {
        this.main = main;
    }

    @FXML
    public void initialize() {
        createRecommendationButton.setOnAction(event -> handleCreateRecommendation());
        editSelectionsButton.setOnAction(event -> handleEditSelections());
        logoutButton.setOnAction(event -> handleLogout());
    }

    public void handleCreateRecommendation() {
        try {
            main.showRecommendationScene();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleEditSelections() {
        try {
            main.showEditSelectionScene((Stage) editSelectionsButton.getScene().getWindow());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void handleLogout() {
        try {
            main.showLoginScene();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
