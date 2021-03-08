package com.example.buildmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Materials extends AppCompatActivity {
    private Button materialsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);
        materialsButton = (Button) findViewById(R.id.addMaterials);
        materialsButton.setOnClickListener(v -> openAddMaterials());
    }

    public void openAddMaterials(){
        Intent navigateToStyleScreen = new Intent(this, AddMaterials.class);
        startActivity(navigateToStyleScreen);
    }
}