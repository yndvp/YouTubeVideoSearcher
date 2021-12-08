package com.example.youtubevideosearcher.Controllers;

import com.example.youtubevideosearcher.APIUtility;
import com.example.youtubevideosearcher.Models.APIResponse;
import com.example.youtubevideosearcher.Models.YouTubeVideo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchViewController implements Initializable {

    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<YouTubeVideo> dataListView;

    @FXML
    private Button detailButton;

    @FXML
    private ImageView thumbnailImageView;

    @FXML
    private void getSearchResults() throws IOException, InterruptedException {
        dataListView.getItems().clear();
        APIResponse apiResponse = APIUtility.getVideoFromYouTubeData(searchTextField.getText());
        if(apiResponse != null)
        {
            dataListView.getItems().addAll(apiResponse.getItems());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVideo, videoSelected) -> {
                    try {
                        thumbnailImageView.setImage(new Image(videoSelected.getSnippet().getThumbnails().get("default").get("url")));
                    } catch (Exception e)
                    {

                    }
                }
        );
    }
}
