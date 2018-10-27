package com.thenopebox.pinet.dashboard.javafx.home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        final FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/HomeScene.fxml"));

        final AnchorPane page = (AnchorPane) loader.load();

        final Scene scene = new Scene(page);

        primaryStage.setTitle("Sign In");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
