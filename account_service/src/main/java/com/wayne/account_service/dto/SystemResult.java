package com.wayne.account_service.dto;

import com.wayne.account_service.enum_class.SystemResultStatus;

/**
 * @Classname SystemResult
 * @Description Hope No Bugs!
 * @Date 2019/4/16 19:04
 * @Created by wayne
 */
public class SystemResult <T> {
    /**
     *消息体
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
