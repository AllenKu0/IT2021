package com.example.itcheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void order(View v){
        CheckBox chk;
        String msg ="";
        int id[] ={R.id.cb1,R.id.cb2,R.id.cb3,R.id.cb4,R.id.cb5,R.id.cb6};

        for(int i:id){
            chk =(CheckBox)findViewById(i);
            if(chk.isChecked())
                msg+="\n"+chk.getText();
        }
        if(msg.length()>0)
            msg="你點購的是"+msg;
        else
            msg ="請選擇餐點!";

        TextView tx1 = (TextView)findViewById(R.id.tx1);
        tx1.setText(msg);
    }
}