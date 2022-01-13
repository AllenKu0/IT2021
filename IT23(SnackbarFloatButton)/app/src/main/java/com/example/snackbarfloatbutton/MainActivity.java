package com.example.snackbarfloatbutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinatorLayout);
    }

    public void open(View v) {
        Snackbar.make(coordinatorLayout, "我是Snackbar", Snackbar.LENGTH_LONG)
                .setAction("按我一下", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 點擊訊息時要執行的動作
                        Toast.makeText(MainActivity.this, "你按了 Snackbar", Toast.LENGTH_SHORT).show();
                    }
                })
                .setActionTextColor(Color.YELLOW)    // 還可以指定 文字顏色
                .show();
    }
}