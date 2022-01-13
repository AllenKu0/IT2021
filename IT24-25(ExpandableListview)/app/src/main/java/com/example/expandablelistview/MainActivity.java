package com.example.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Group> gData = null;
    private ArrayList<ArrayList<Content>> iData = null;
    private ArrayList<Content> lData = null;
    private Context mContext;
    private ExpandableListView language_list;
    private MsExpandableListAdapter msAdapter = null;
    private String Title[]={"請選擇語言","請選擇性別"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        language_list = (ExpandableListView) findViewById(R.id.ep1);
        gData = new ArrayList<Group>();
        iData = new ArrayList<ArrayList<Content>>();
        gData.add(new Group("請選擇語言"));
        gData.add(new Group("請選擇性別"));

        lData = new ArrayList<Content>();
        lData.add(new Content("繁體中文"));
        lData.add(new Content("英文"));
        lData.add(new Content("法文"));
        lData.add(new Content("日文"));
        lData.add(new Content("韓文"));
        iData.add(lData);
        lData = new ArrayList<Content>();
        lData.add(new Content("男"));
        lData.add(new Content("女"));
        iData.add(lData);

        msAdapter = new MsExpandableListAdapter(gData,iData,mContext);
        language_list.setAdapter(msAdapter);
        //組的按鈕事件
        language_list.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(MainActivity.this,Title[groupPosition],Toast.LENGTH_SHORT).show();
                //需 return false 才能展開子類
                return false;
            }
        });
        //子類的按鈕事件
        language_list.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String select = iData.get(groupPosition).get(childPosition).getName();
                gData.get(groupPosition).setName(select);
                //收起子類欄位
                language_list.collapseGroup(groupPosition);
                return true;
            }
        });
    }
}