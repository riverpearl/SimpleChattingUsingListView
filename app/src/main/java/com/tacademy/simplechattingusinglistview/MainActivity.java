package com.tacademy.simplechattingusinglistview;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.tacademy.simplechattingusinglistview.Data.DateData;
import com.tacademy.simplechattingusinglistview.Data.ReceiveData;
import com.tacademy.simplechattingusinglistview.Data.SendData;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText messageView;
    RadioGroup messageType;
    ChattingAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView4);
        messageView = (EditText)findViewById(R.id.edit_message);
        messageType = (RadioGroup)findViewById(R.id.group_view_type);
        mAdapter = new ChattingAdapter();

        listView.setAdapter(mAdapter);

        Button btn = (Button)findViewById(R.id.btn_insert);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messageView.getText().toString();

                if(!TextUtils.isEmpty(message)) {
                    switch (messageType.getCheckedRadioButtonId()) {
                        case R.id.radio_send :
                            SendData sendData = new SendData();
                            sendData.setMessage(message);
                            sendData.setPhoto(ContextCompat.getDrawable(MainActivity.this, R.drawable.sample_0));
                            mAdapter.add(sendData);
                            break;

                        case R.id.radio_receive :
                            ReceiveData receiveData = new ReceiveData();
                            receiveData.setMessage(message);
                            receiveData.setPhoto(ContextCompat.getDrawable(MainActivity.this, R.drawable.sample_1));
                            mAdapter.add(receiveData);
                            break;

                        case R.id.radio_date :
                            DateData dateData = new DateData();
                            dateData.setMessage(message);
                            mAdapter.add(dateData);
                            break;
                    }

                    messageView.setText("");
                }
            }
        });
    }
}
