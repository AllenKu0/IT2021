package com.example.itintentbundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2,et3;
    private Button bt1;
    private String content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button)findViewById(R.id.bt1);
        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        et3 = (EditText)findViewById(R.id.et3);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                                       //content = et1.getText().toString().trim();trim負責刪除字串中的空白或特數字符\n等
                if(et1.getText().toString().matches("")){                //TextUtils.isEmpty(content)
                    Toast.makeText(MainActivity.this,"說點甚麼吧",Toast.LENGTH_SHORT).show();
                }
                else if(et2.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"請輸入日期~",Toast.LENGTH_SHORT).show();
                }
                else{
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent();
                    //bundle可以根據要傳送的資料選擇put的型態，括號內分別是(key,value)
                    bundle.putString("content",et1.getText().toString());
                    bundle.putInt("month",Integer.parseInt(et2.getText().toString()));
                    bundle.putInt("date",Integer.parseInt(et3.getText().toString()));
                    //把bundle綁入Intent
                    intent.putExtras(bundle);
                    //設定要跳轉的兩個Activity
                    intent.setClass(MainActivity.this,SecondActivity2.class);
                    //啟動intent，執行畫面跳轉
                    startActivity(intent);
                }
            }
        });
    }
}