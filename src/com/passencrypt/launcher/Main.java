package com.passencrypt.launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String version = "0.11.14";
        Parent root = FXMLLoader.load(getClass().getResource("../view/sample.fxml"));
        primaryStage.setTitle("PassEncrypt v.:" + version);
        primaryStage.setScene(new Scene(root, 770.0, 563.0));
        primaryStage.show();
    }
}
