package com.example.itfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button bt1;
    private Button bt2;
    private AFragment aFragment;
    private BFragment bFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button)findViewById(R.id.bt1);
        bt2 = (Button)findViewById(R.id.bt2);
        aFragment = new AFragment();
        //透過getSupportFragmentManager()，獲取FragmentManager並使用beginTransaction()開啟一個事務。最後將Fragmnet加入容器內的方法，可以使用add。
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,aFragment,"A").commit();
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aFragment == null)
                    aFragment = new AFragment();
                //這裡要做到替換的效果，所以我們用replace做到取代。
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,aFragment,"A").commit();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFragment == null)
                    bFragment = new BFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment,"B").commit();
            }
        });
    }
}