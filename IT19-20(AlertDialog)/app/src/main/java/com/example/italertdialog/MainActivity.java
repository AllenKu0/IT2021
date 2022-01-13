package com.example.italertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void firstAloert(View v){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle("我是標題").setMessage("AlertDialog介紹").setIcon(R.mipmap.ic_launcher);
        builder1.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //放置確定按鈕的功能
            }
        });
        builder1.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //放置取消按鈕的功能
            }
        });
        builder1.setNeutralButton("中立", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //放置中立按鈕的功能
            }
        });
        builder1.setCancelable(true);
        builder1.show();
    }
    public void secondAlert(View v){
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        final View dialog2 = inflater.inflate(R.layout.alertdialog1,null);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setView(dialog2);
        Button bt1 = (Button)dialog2.findViewById(R.id.bt1);
        Button bt2 = (Button)dialog2.findViewById(R.id.bt2);
        AlertDialog ad1 = builder2.create();
        ad1.setCancelable(true);                //設定返回鍵是否可以關掉AlertDialog
        ad1.show();
        bt1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_SHORT).show();
                ad1.dismiss();
            }
        });
        bt2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this,"確定",Toast.LENGTH_SHORT).show();
            }
        });
    }
}