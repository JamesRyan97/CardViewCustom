package com.james.cardviewcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private CardViewCustom cvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvMain = findViewById(R.id.cvMain);
//
//        cvMain.setCornerRadiusMain(0,0,40,40);
//
//        cvMain.setMarginMain(0,0,20,0);
//
//        cvMain.setBackgroundColorCardView(Color.BLUE);
    }
}