package com.example.it5button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1;                       //變數宣告
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);       //取的物件
    }

    public void show(View v){
        Toast.makeText(MainActivity.this,"",Toast.LENGTH_SHORT).show();
        if(et1.getText().toString().equals("")){
            et1.setError("輸入框不得為空");
        }
        else{
            Toast.makeText(MainActivity.this,et1.getText()+"您好",Toast.LENGTH_SHORT).show();

        }
    }
}