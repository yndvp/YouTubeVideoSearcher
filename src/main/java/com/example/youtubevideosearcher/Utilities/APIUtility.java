package com.example.youtubevideosearcher.Utilities;

import com.example.youtubevideosearcher.Models.APIResponse;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {
    /**
     * This method will read "jsonData.json" file and create an APIResponse object
     */
    public static APIResponse getVideosFromJsonFile()
    {
        // create a GSON object
        Gson gson = new Gson();
        APIResponse response = null;

        try (
                FileReader fileReader = new FileReader("jsonData.json");
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            response = gson.fromJson(jsonReader, APIResponse.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * This will call the YouTube Data API and send the result to a json file
     */
    public static APIResponse getVideoFromYouTubeData(String searchTerm) throws IOException, InterruptedException {

        searchTerm = searchTerm.trim().replace(" ", "%20");

        String uri = "https://youtube.googleapis.com/youtube/v3/search?key=AIzaSyAkhKl9YM2MQvtgDgHzOjB06rWKoe_XaEQ&part=snippet&maxResults=25&q=" + searchTerm;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<Path> response = client.send(httpRequest, HttpResponse
                .BodyHandlers
                .ofFile(Paths.get("jsonData.json")));

        return getVideosFromJsonFile();
    }

}
