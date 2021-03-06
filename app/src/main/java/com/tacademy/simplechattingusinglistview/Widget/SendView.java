package com.tacademy.simplechattingusinglistview.Widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.tacademy.simplechattingusinglistview.Data.SendData;
import com.tacademy.simplechattingusinglistview.R;

/**
 * Created by Tacademy on 2016-07-21.
 */
public class SendView extends FrameLayout {

    TextView messageView;
    ImageView photoView;

    SendData data;

    public SendView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_send, this);
        messageView = (TextView)findViewById(R.id.text_message);
        photoView = (ImageView)findViewById(R.id.image_photo);
    }

    public void setData(SendData data) {
        this.data = data;
        messageView.setText(data.getMessage());
        photoView.setImageDrawable(data.getPhoto());
    }
}
