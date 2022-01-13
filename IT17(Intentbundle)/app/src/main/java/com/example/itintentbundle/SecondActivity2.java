package com.example.itintentbundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity2 extends AppCompatActivity {
    private TextView tx1,tx2,tx3;
    private String content,month,date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        tx1 = (TextView)findViewById(R.id.tx1);
        tx2 = (TextView)findViewById(R.id.tx2);
        tx3 = (TextView)findViewById(R.id.tx3);
        //取得bundle，慢慢拆解從Intent中找到附加的資料
        Bundle bundle = getIntent().getExtras();
        //拆出bundle的內容，key為content
        content=bundle.getString("content");
        //拆出bundle的內容，key為mounth，並將Int型態轉換為String
        month = String.valueOf(bundle.getInt("month"));
        //拆出bundle的內容，key為date，並將Int型態轉換為String
        date = String.valueOf(bundle.getInt("date"));
        tx1.setText(content);
        tx2.setText(month);
        tx3.setText(date);
    }
}