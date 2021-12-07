package com.example.youtubevideosearcher.Controllers;

import com.example.youtubevideosearcher.APIUtility;
import com.example.youtubevideosearcher.APIResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SearchViewController {

    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<?> dataListView;

    @FXML
    private Button detailButton;

    @FXML
    void getSearchResults(ActionEvent event) throws IOException, InterruptedException {
        dataListView.getItems().clear();
        APIResponse apiResponse = APIUtility.getVideoFromYouTubeData(searchTextField.getText());
        if(apiResponse != null)
        {
//            dataListView.getItems().addAll(apiResponse.getItems());
        }
    }

}
