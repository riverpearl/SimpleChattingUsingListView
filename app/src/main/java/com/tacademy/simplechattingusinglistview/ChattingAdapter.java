package com.tacademy.simplechattingusinglistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tacademy.simplechattingusinglistview.Data.ChattingData;
import com.tacademy.simplechattingusinglistview.Data.DateData;
import com.tacademy.simplechattingusinglistview.Data.ReceiveData;
import com.tacademy.simplechattingusinglistview.Data.SendData;
import com.tacademy.simplechattingusinglistview.Widget.DateView;
import com.tacademy.simplechattingusinglistview.Widget.ReceiveView;
import com.tacademy.simplechattingusinglistview.Widget.SendView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-07-21.
 */
public class ChattingAdapter extends BaseAdapter {
    List<ChattingData> items = new ArrayList<>();

    private final static int VIEW_TYPE_COUNT = 3;
    private final static int VIEW_INDEX_SEND = 0;
    private final static int VIEW_INDEX_RECEIVE = 1;
    private final static int VIEW_INDEX_DATE = 2;


    public void add(ChattingData data) {
        items.add(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        ChattingData data = items.get(position);

        if (data instanceof SendData) return VIEW_INDEX_SEND;
        else if (data instanceof ReceiveData) return VIEW_INDEX_RECEIVE;
        else if (data instanceof DateData) return VIEW_INDEX_DATE;

        throw new IllegalArgumentException("Invalid Position");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case VIEW_INDEX_SEND :
                SendView sendView;
                if (convertView == null || !(convertView instanceof SendView))
                    sendView = new SendView(parent.getContext());
                else sendView = (SendView)convertView;
                sendView.setData((SendData)items.get(position));
                return sendView;

            case VIEW_INDEX_RECEIVE :
                ReceiveView receiveView;
                if (convertView == null || !(convertView instanceof ReceiveView))
                    receiveView = new ReceiveView(parent.getContext());
                else receiveView = (ReceiveView)convertView;
                receiveView.setData((ReceiveData)items.get(position));
                return receiveView;

            case VIEW_INDEX_DATE :
                DateView dateView;
                if (convertView == null || !(convertView instanceof DateView))
                    dateView = new DateView(parent.getContext());
                else dateView = (DateView)convertView;
                dateView.setData((DateData)items.get(position));
                return dateView;
        }

        throw new IllegalArgumentException("Invalid Position");
    }
}
