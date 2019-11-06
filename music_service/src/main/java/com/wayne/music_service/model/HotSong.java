package com.wayne.music_service.model;

public class HotSong {
    private Long id;

    private String play_list_id;

    private String song_id;

    private String song_name;

    private String songer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlay_list_id() {
        return play_list_id;
    }

    public void setPlay_list_id(String play_list_id) {
        this.play_list_id = play_list_id == null ? null : play_list_id.trim();
    }

    public String getSong_id() {
        return song_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id == null ? null : song_id.trim();
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name == null ? null : song_name.trim();
    }

    public String getSonger() {
        return songer;
    }

    public void setSonger(String songer) {
        this.songer = songer == null ? null : songer.trim();
    }

    @Override
    public String toString() {
        return "HotSong{" +
                "id=" + id +
                ", play_list_id='" + play_list_id + '\'' +
                ", song_id='" + song_id + '\'' +
                ", song_name='" + song_name + '\'' +
                ", songer='" + songer + '\'' +
                '}';
    }
}