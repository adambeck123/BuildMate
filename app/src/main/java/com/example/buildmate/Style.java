package com.example.buildmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Style extends AppCompatActivity {

    public Button HouseStyle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);

        HouseStyle = (Button) findViewById(R.id.newHouseStyle);
        HouseStyle.setOnClickListener(v -> openAddHouseStyle());

    }
    public void openAddHouseStyle(){
        Intent navigateToStyleScreen = new Intent(this, AddHouseStyle.class);
        startActivity(navigateToStyleScreen);
    }
}