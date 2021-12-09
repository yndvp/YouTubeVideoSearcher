package com.example.youtubevideosearcher.Controllers;

import com.example.youtubevideosearcher.Utilities.APIUtility;
import com.example.youtubevideosearcher.Models.APIResponse;
import com.example.youtubevideosearcher.Models.YouTubeVideo;
import com.example.youtubevideosearcher.Utilities.SceneChanger;
import javafx.event.ActionEvent;
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

    /**
     * This method is executed when user press the search button.
     * This method populate objects data from API to list view
     */
    @FXML
    private void getSearchResults() throws IOException, InterruptedException {
        dataListView.getItems().clear();
        APIResponse apiResponse = APIUtility.getVideoFromYouTubeData(searchTextField.getText());
        if(apiResponse != null)
        {
            dataListView.getItems().addAll(apiResponse.getItems());
            setVideoSelected(false);
        }
    }
    /**
     * This method initialize the view. In this method, event listener is attached to data list view
     * so that it can load thumbnail that matched with video
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVideo, videoSelected) -> {
                    try {
                        thumbnailImageView.setImage(new Image(videoSelected.getSnippet().getThumbnails().get("default").get("url")));
                        setVideoSelected(true);
                    } catch (Exception e)
                    {

                    }
                }
        );
    }

    /**
     * This method decide visibility of elements depends if video is selected or not
     */
    private void setVideoSelected(boolean videoSelected)
    {
        detailButton.setVisible(videoSelected);
        thumbnailImageView.setVisible(videoSelected);
    }

    /**
     * This method is launched when user click view details button
     */
    @FXML
    private void getVideoDetails(ActionEvent event) throws IOException, InterruptedException {
        YouTubeVideo video = dataListView.getSelectionModel().getSelectedItem();
        SceneChanger.changeScenes(event, "video-details-view.fxml", video);
    }
}
