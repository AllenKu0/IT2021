package com.example.itrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<String> titleList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //給titleList資料
        for(int i = 0;i<20;i++){
            titleList.add("項目"+i);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));     //垂直向下排列
        recyclerView.addItemDecoration(new DividerItemDecoration(this,    //分隔線
                DividerItemDecoration.VERTICAL));
        adapter = new MyAdapter(titleList);                                       //將串列titlelist傳入MyAdapter，最後由recyclerView取用
        recyclerView.setAdapter(adapter);
    }
}