package com.example.youtubevideosearcher.Models;

import com.example.youtubevideosearcher.Models.Snippet;

import java.util.HashMap;

public class YouTubeVideo {
    /**
     * Instance variables
     */
    private String kind;
    private String etag;
    private HashMap<String, String> id;
    private Snippet snippet;

    /**
     * Setters and Getters
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

    public HashMap<String, String> getId() {
        return id;
    }

    public void setId(HashMap<String, String> id) {
        this.id = id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    /**
     * Method to convert object to string
     */
    public String toString(){return String.format("%s %s", kind, etag);}
}
