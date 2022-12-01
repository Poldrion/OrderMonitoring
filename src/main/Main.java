package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.PrimaryStageAware;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/mainWindow.fxml"));
            loader.setControllerFactory((Class<?> type) -> {
                try {
                    Object controller = type.newInstance();
                    if (controller instanceof PrimaryStageAware) {
                        ((PrimaryStageAware) controller).setPrimaryStage(primaryStage);
                    }
                    return controller;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            Parent root = loader.load();
            primaryStage.setTitle("Контроль передачи потребности");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
