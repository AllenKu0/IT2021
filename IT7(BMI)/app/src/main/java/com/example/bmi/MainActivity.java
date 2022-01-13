package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText height;     //宣告變數，型態為EditText(全域變數)
    EditText weight;     //宣告變數，型態為EditText(全域變數)
    Button bt1;     //宣告變數，型態為Button(全域變數)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height=(EditText)findViewById(R.id.et1);     //取得輸入物件(身高)
        weight=(EditText)findViewById(R.id.et2);     //取得輸入物件(體重)
    }
    public void calculate(View v){              //按鈕事件
        if(!("".equals(height.getEditableText().toString())) ||
                !("".equals(weight.getEditableText().toString()))){              //判斷輸入是否為空值
            float fh=Float.parseFloat(height.getEditableText().toString());      //將輸入值(身高)的字串，轉換會為float
            float fw=Float.parseFloat(weight.getEditableText().toString());      //將輸入值(體重)的字串，轉換會為float
            float fresult;                                                  //宣告變數，型態為float(區域變數)
            TextView result=(TextView)findViewById(R.id.tx5);               //取得物件，放置BMI結果
            fh=fh/100;
            fh=fh*fh;
            NumberFormat nf=NumberFormat.getInstance();                     //設定數字格式，並宣告物件nf
            nf.setMaximumFractionDigits(2);                                 //小數點設定顯示最多後兩位
            fresult=fw/fh;
            result.setText(nf.format(fresult)+"");                          //將算出來的BMI格式化
            TextView dia=(TextView)findViewById(R.id.tx6);                  //取得物件，放置診斷結果

            if(fresult<18.5)                                                //判斷BMI的數值
                dia.setText("體重過輕");
            else if(fresult>=18.5&&fresult<24)
                dia.setText("正常範圍");
            else if(fresult>=24&&fresult<27)
                dia.setText("過重");
            else if(fresult>=27&&fresult<30)
                dia.setText("輕度肥胖");
            else if(fresult>=30&&fresult<35)
                dia.setText("中度肥胖");
            else if(fresult>=35)
                dia.setText("重度肥胖");
        }
    }
}