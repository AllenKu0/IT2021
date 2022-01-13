package com.example.sharedprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences pref;
    EditText account,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        account = (EditText) findViewById(R.id.account);
        password = (EditText) findViewById(R.id.password);
    }
    //新增儲存資料
    public void sava(View v){
        pref = getSharedPreferences("DATA",MODE_PRIVATE);
        pref.edit()
            .putString("NAME",account.getText().toString())
            .putString("PHONE",password.getText().toString())
            .apply();                   //或commit()
        //Editor寫法
        /*SharedPreferences.Editor editor = pref.edit();
        editor.putString();
        editor.remove("key");*/

    }
    //讀取資料
    public void read(View v){
        pref = getSharedPreferences("DATA",MODE_PRIVATE);
        account.setText(pref.getString("NAME",""));
        password.setText(pref.getString("PHONE",""));
    }
    //清除EditTexts內容
    public void clear(View v){
        pref = getSharedPreferences("DATA",MODE_PRIVATE);
        account.setText("");
        password.setText("");
        //下面程式碼能清除所有資料
        /*SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();*/

    }
}