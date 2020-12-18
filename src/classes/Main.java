package classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent menuParent = FXMLLoader.load(getClass().getResource("menu.fxml"));
        primaryStage.setTitle("Calculatrice de matrices");
        Scene menuScene = new Scene(menuParent);
        primaryStage.setScene(menuScene);
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}