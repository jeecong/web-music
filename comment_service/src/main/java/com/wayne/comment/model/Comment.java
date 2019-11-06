package com.wayne.comment.model;

public class Comment {
    private Long id;

    private Long song_id;

    private Long user_id;

    private Long publish_time;

    private Integer status;

    private String extension;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSong_id() {
        return song_id;
    }

    public void setSong_id(Long song_id) {
        this.song_id = song_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(Long publish_time) {
        this.publish_time = publish_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension == null ? null : extension.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", song_id=" + song_id +
                ", user_id=" + user_id +
                ", publish_time=" + publish_time +
                ", status=" + status +
                ", extension='" + extension + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}