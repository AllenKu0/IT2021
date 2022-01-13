package com.example.ittoggleswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleButton;
    private Switch st1;
    private TextView tx1;
    private TextView tx2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton=(ToggleButton)findViewById(R.id.tg1);
        st1 = (Switch)findViewById(R.id.st1);
        tx1 = (TextView)findViewById(R.id.tx1);
        tx2 = (TextView)findViewById(R.id.tx2);

        st1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tx1.setText(isChecked?"啟用":"禁用");
                toggleButton.setEnabled(isChecked);
            }
        });
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tx2.setText(isChecked?"開":"關");
            }
        });

    }
}