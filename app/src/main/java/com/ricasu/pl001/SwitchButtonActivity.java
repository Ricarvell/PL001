package com.ricasu.pl001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SwitchButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_button);

        switch1 = findViewById(R.id.switch1);

        switch1.setChecked(true);
    }
}
