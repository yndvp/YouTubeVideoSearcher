package com.example.youtubevideosearcher.Models;

import java.util.HashMap;

public class Snippet {
    private String publishedAt;
    private String channelId;
    private String title;
    private String description;
    private HashMap<String, HashMap<String, String>> thumbnails;
    private String channelTitle;
    private String liveBroadcastContent;
    private String publishTime;

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HashMap<String, HashMap<String, String>> getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(HashMap<String, HashMap<String, String>> thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getLiveBroadcastContent() {
        return liveBroadcastContent;
    }

    public void setLiveBroadcastContent(String liveBroadcastContent) {
        this.liveBroadcastContent = liveBroadcastContent;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String toString(){return String.format("%s", getTitle().trim().replace("&#39;", "'"));}
}
