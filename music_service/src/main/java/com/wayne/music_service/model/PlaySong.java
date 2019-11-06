package com.wayne.music_service.model;

/**
 * @Classname PlaySong
 * @Description Hope No Bugs!
 * @Date 2019/4/20 15:51
 * @Created by wayne
 */
public class PlaySong {
    private  String mp3;
    private String oga;
    private  String title;
    private String artist;
    private String rating;
    private String  buy;
    private  String price;
    private String duration;
    private String cover;


    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public String getOga() {
        return oga;
    }

    public void setOga(String oga) {
        this.oga = oga;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public PlaySong() {
    }
}
