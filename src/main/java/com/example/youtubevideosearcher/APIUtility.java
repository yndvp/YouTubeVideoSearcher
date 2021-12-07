package com.example.youtubevideosearcher;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIUtility {
    /**
     * This will call the YouTube Data API with the specified search term
     */

    public static APIResponse getVideoFromYouTubeData(String searchTerm) throws IOException, InterruptedException {

        searchTerm = searchTerm.trim().replace(" ", "%20");

        String uri = "https://youtube.googleapis.com/youtube/v3/search?key=AIzaSyAkhKl9YM2MQvtgDgHzOjB06rWKoe_XaEQ&part=snippet&maxResults=25&q=" + searchTerm;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        // this approach stores the API response to a String and then creates objects
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        String jsonString = response.body();
        System.out.println(jsonString);

        Gson gson = new Gson();
        APIResponse apiResponse = null;

        try {
            apiResponse = gson.fromJson(jsonString, APIResponse.class);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return apiResponse;
    }

}
