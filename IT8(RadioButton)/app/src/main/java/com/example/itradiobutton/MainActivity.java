package com.example.itradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1 = (Button) findViewById(R.id.bt1);

        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView txv = (TextView) findViewById(R.id.txv);
                RadioGroup ticketType =
                        (RadioGroup) findViewById(R.id.ticketType);
                RadioGroup tickeNumber =
                        (RadioGroup) findViewById(R.id.ticketNumber);

                RadioButton type = (RadioButton)findViewById(
                        ticketType.getCheckedRadioButtonId());
                RadioButton number = (RadioButton)findViewById(
                        tickeNumber.getCheckedRadioButtonId());

                txv.setText("買"+type.getText()+" "+number.getText()+"張");
            }
        });
    }
}