package com.mycompany.mavenproject1;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.fxml.FXMLLoader;

public class App extends Application {

    @Override
    public void start(final Stage stage) throws IOException {
        String resourcePath = "/view/primary.fxml";
        URL location = this.getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);

        Scene scene = new Scene(fxmlLoader.load(), 500, 500);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
