package com.example.codefy;

public class Podcast {
    private String podcast_title;
    private String podcast_author;
    private String podcast_cover;
    private int position;

    public Podcast(String podcast_author, String podcast_title, String podcast_cover) {
        this.podcast_author = podcast_author;
        this.podcast_title = podcast_title;
        this.podcast_cover = podcast_cover;
    }


    public void setPodcast_cover(String podcast_cover){
        this.podcast_cover = podcast_cover;
    }

    public String getPodcast_cover() {
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
}
