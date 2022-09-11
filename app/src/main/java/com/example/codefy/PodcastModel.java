package com.example.codefy;

public class PodcastModel {
    private String podcast_title;
    private String podcast_author;
    private int podcast_cover;
    private String podcast_audio_path;

    public PodcastModel(String podcast_author, String podcast_title, int podcast_cover, String podcast_audio_path) {
        this.podcast_author = podcast_author;
        this.podcast_title = podcast_title;
        this.podcast_cover = podcast_cover;
        this.podcast_audio_path = podcast_audio_path;
    }


    public void setPodcast_cover(int podcast_cover){
        this.podcast_cover = podcast_cover;
    }

    public int getPodcast_cover() {
        return podcast_cover;
    }

    public String getPodcast_author() {
        return podcast_author;
    }

    public void setPodcast_author(String podcast_author) {
        this.podcast_author = podcast_author;
    }

    public String getPodcast_title() {
        return podcast_title;
    }

    public void setPodcast_title(String podcast_title) {
        this.podcast_title = podcast_title;
    }

    public String getPodcast_audio_path() {
        return podcast_audio_path;
    }

    public void setPodcast_audio_path(String podcast_audio_path) {
        this.podcast_audio_path = podcast_audio_path;
    }
}
