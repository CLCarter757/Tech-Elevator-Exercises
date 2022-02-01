package com.techelevator;

public class Music extends MediaItem{
    private String artist;


    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Music(String artist, String title, double price) {
        this.artist = artist;
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Artist: " + artist + ", Album: " + title + ", Price: $" + price;
    }
}
