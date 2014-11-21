package com.passencrypt.launcher;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @FXML
    private AnchorPane rootLayout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String version = "0.11.14";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/sample.fxml"));

        rootLayout = loader.load();
        loader.setRoot(rootLayout);

        Scene scene = new Scene(rootLayout, 770.0, 563.0);

        primaryStage.setTitle("PassEncrypt v.:" + version);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
