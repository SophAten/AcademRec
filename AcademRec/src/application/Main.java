package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private SharedDataModel sharedDataModel;

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        sharedDataModel = new SharedDataModel();
        showLoginScene();
    }

    public void showLoginScene() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Login.fxml"));
        loader.setControllerFactory(param -> new LoginController(this));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);

        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.setTitle("Login");
        newStage.show();

        primaryStage.close();
        primaryStage = newStage;
    }

    public void showChangePasswordScene() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resetPassword.fxml"));
        loader.setControllerFactory(param -> new ResetPasswordController(this));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);

        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.setTitle("Change Password");
        newStage.show();

        primaryStage.close();
        primaryStage = newStage;
    }

    public void showMenuScene() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        loader.setControllerFactory(param -> new MenuController(this));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);

        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.setTitle("Menu");
        newStage.show();

        primaryStage.close();
        primaryStage = newStage;
    }

    public void showRecommendationScene() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Recommendation.fxml"));
        loader.setControllerFactory(param -> new RecommendationController(this));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);

        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.setTitle("Create Recommendation");
        newStage.show();

        primaryStage.close();
        primaryStage = newStage;
    }

    public void showEditSelectionScene(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DropdownSelection.fxml"));

        loader.setControllerFactory(param -> new DropdownSelectionController(this, sharedDataModel));

        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Edit Selections");
        primaryStage.show();

        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.setTitle("Edit Selections");
        newStage.show();

        primaryStage.close();
        primaryStage = newStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    } 

}