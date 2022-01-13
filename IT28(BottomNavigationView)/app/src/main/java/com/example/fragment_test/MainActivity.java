package com.example.fragment_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private AFragment aFragment;
    private BFragment bFragment;
    private CFragment cFragment;
    private BottomNavigationView bottomNavigationView;
    private Button bt1;
    private Toolbar toolbar;

    //動態更改NavigationBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        for(int i=0;i<menu.size();i++){
            menu.getItem(i).setVisible(false);

        }
        MenuItem item = menu.findItem(R.id.search_button);
        item.setVisible(true);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.search_button:
                Toast.makeText(this,"search_button",Toast.LENGTH_SHORT).show();
            case R.id.scan_button:
                Toast.makeText(this,"scan_button",Toast.LENGTH_SHORT).show();
            case R.id.setting_button:
                Toast.makeText(this,"setting_button",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aFragment = new AFragment();
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        // 用toolbar做為APP的ActionBar
        setSupportActionBar(toolbar);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,aFragment,"A").commitAllowingStateLoss();
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        //BottomNavigationView的監聽事件設定
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            //檢測哪個項目被選擇
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        if(aFragment==null)
                            aFragment=new AFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,aFragment,"A").commitAllowingStateLoss();
                        toolbar.getMenu().findItem(R.id.search_button).setVisible(true);
                        toolbar.getMenu().findItem(R.id.scan_button).setVisible(false);
                        toolbar.getMenu().findItem(R.id.setting_button).setVisible(false);

                        break;
                    case R.id.dashboard:
                        if(bFragment==null)
                            bFragment=new BFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment,"B").commitAllowingStateLoss();
                        toolbar.getMenu().findItem(R.id.search_button).setVisible(false);
                        toolbar.getMenu().findItem(R.id.scan_button).setVisible(true);
                        toolbar.getMenu().findItem(R.id.setting_button).setVisible(false);
                        break;
                    case R.id.notify:
                        if(cFragment==null)
                            cFragment=new CFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,cFragment,"C").commitAllowingStateLoss();
                        toolbar.getMenu().findItem(R.id.search_button).setVisible(false);
                        toolbar.getMenu().findItem(R.id.scan_button).setVisible(false);
                        toolbar.getMenu().findItem(R.id.setting_button).setVisible(true);
                        break;
                }
                return true;
            }
        });
    }
}