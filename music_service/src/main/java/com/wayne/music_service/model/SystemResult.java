package com.wayne.music_service.model;

/**
 * @Classname SystemResult
 * @Description Hope No Bugs!
 * @Date 2019/5/5 22:32
 * @Created by wayne
 */
public class SystemResult <T> {
    /**
     * 消息体
     */
    private T object;

    private SystemResultStatus status;
    private String extension;

    public SystemResult() {
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public SystemResultStatus getStatus() {
        return status;
    }

    public void setStatus(SystemResultStatus status) {
        this.status = status;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "SystemResult{" +
                "object=" + object +
                ", status=" + status +
                ", extension='" + extension + '\'' +
                '}';
    }
}
