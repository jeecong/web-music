package com.wayne.account_service.dto;

import com.wayne.account_service.enum_class.Status;
import com.wayne.account_service.enum_class.SystemResultStatus;

/**
 * @Classname Message
 * @Description Hope No Bugs!
 * @Date 2019/4/15 11:00
 * @Created by wayne
 */
public class Message<T> {
    /**
     *消息体
     */
    private T object;

    private SystemResultStatus status;
    private String extension;

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
}
