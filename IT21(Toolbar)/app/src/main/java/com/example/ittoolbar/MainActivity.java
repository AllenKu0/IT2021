package com.example.ittoolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setNavigationIcon(R.mipmap.ic_launcher);//设置导航栏图标

        // 用toolbar做為APP的ActionBar
        setSupportActionBar(toolbar);

        //顯示返回箭頭
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //左上角圖片致能，測試沒用
        getSupportActionBar().setHomeButtonEnabled(true);

        //設置左上角圖示功能
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "返回", Toast.LENGTH_SHORT).show();
            }
        });
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // 設置要用哪個menu檔做為選單
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;   //返回true表顯示
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // 取得點選項目的id
//        int id = item.getItemId();
//
//        // 依照id判斷點了哪個項目並做相應事件
//        if (id == R.id.setting) {
//            // 按下「設定」要做的事
//            Toast.makeText(this, "設定", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        else if (id == R.id.help) {
//            // 按下「使用說明」要做的事
//            Toast.makeText(this, "使用說明", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        else if (id == R.id.about) {
//            // 按下「關於」要做的事
//            Toast.makeText(this, "關於", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        else if (id == R.id.home){
//            Toast.makeText(this, "返回", Toast.LENGTH_SHORT).show();
//            return true;//測試沒用
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}