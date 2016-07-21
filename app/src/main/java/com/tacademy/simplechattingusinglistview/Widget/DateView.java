package com.tacademy.simplechattingusinglistview.Widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.tacademy.simplechattingusinglistview.Data.DateData;
import com.tacademy.simplechattingusinglistview.R;

/**
 * Created by Tacademy on 2016-07-21.
 */
public class DateView extends FrameLayout {

    TextView messageView;
    DateData data;

    public DateView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_date, this);
        messageView = (TextView)findViewById(R.id.text_message);
    }

    public void setData(DateData data) {
        this.data = data;
        messageView.setText(data.getMessage());
    }
}
