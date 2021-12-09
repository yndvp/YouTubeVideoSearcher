package com.example.youtubevideosearcher.Controllers;

import com.example.youtubevideosearcher.Utilities.InitializeVideo;
import com.example.youtubevideosearcher.Models.YouTubeVideo;
import com.example.youtubevideosearcher.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class VideoDetailsViewController implements InitializeVideo {

    @FXML
    private Label titleLabel;

    @FXML
    private Label channelLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private TextArea descriptionLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Button backbutton;

    /**
     * This method populate labels with data object came from API call
     */
    public void loadVideoDetails(YouTubeVideo video)
    {
        titleLabel.setText(video.getSnippet().getTitle());
        channelLabel.setText(video.getSnippet().getChannelTitle());
        dateLabel.setText(video.getSnippet().getPublishTime().substring(0,10));
        descriptionLabel.setText(video.getSnippet().getDescription());
        imageView.setImage(new Image(video.getSnippet().getThumbnails().get("medium").get("url")));
    }

    /**
     * This method change scene to 'search-view' when user click 'go back' button
     */
    @FXML
    private void returnToSearchView(ActionEvent event) throws IOException, InterruptedException {
        SceneChanger.changeScenes(event, "search-view.fxml");
    }
}
