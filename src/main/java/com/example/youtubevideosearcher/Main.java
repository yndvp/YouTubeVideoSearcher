package com.example.youtubevideosearcher;

import com.example.youtubevideosearcher.Models.APIResponse;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        APIResponse result = null;
        try {
            result = APIUtility.getVideoFromYouTubeData("game");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
