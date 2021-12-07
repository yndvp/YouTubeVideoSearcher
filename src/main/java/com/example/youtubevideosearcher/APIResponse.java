package com.example.youtubevideosearcher;


import java.util.HashMap;

public class APIResponse {
    /**
     * Instance variables
     */
    private String kind;
    private String etag;
    private String nextPageToken;
    private String regionCode;
    private HashMap<String, String> pageInfo;
    private YouTubeVideo[] items;

    /**
     * Getters and Setters
     */
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public HashMap<String, String> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(HashMap<String, String> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public YouTubeVideo[] getItems() {
        return items;
    }

    public void setItems(YouTubeVideo[] items) {
        this.items = items;
    }
}
