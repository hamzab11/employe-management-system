package com.ahbpaf.p4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/fxml/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image appIcon = new Image(getClass().getResourceAsStream("/images/appIcon.png"));
        stage.getIcons().add(appIcon);
        stage.setTitle("P4");
        stage.setScene(scene);
        stage.setFullScreenExitHint("press Esc to exit");
        stage.setFullScreen(false);
        stage.setResizable(false);


        stage.show();
    }
}
