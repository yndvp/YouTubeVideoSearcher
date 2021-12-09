package com.example.youtubevideosearcher.Utilities;

import com.example.youtubevideosearcher.Main;
import com.example.youtubevideosearcher.Models.YouTubeVideo;
import com.example.youtubevideosearcher.Utilities.InitializeVideo;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {
    /**
     * This method get YouTubeVideo object as parameter and pass it to the next scene
     */
    public static void changeScenes(ActionEvent event, String fxmlFile, YouTubeVideo video) throws IOException, InterruptedException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        InitializeVideo controller = fxmlLoader.getController();
        controller.loadVideoDetails(video);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    /**
     * This method is for simply going back to other view
     */
    public static void changeScenes(ActionEvent event, String fxmlFile) throws IOException, InterruptedException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
