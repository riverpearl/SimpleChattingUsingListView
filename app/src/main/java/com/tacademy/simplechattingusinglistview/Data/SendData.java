package com.tacademy.simplechattingusinglistview.Data;

import android.graphics.drawable.Drawable;

/**
 * Created by Tacademy on 2016-07-20.
 */
public class SendData implements ChattingData {
    private String message;
    private Drawable photo;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }
}
