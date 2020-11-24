package com.example.buildmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {
    private Button projectNavigation;
    private Button styleNavigation;
    private Button materialsNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        //Button creation for navigation between home screen and project screen
        projectNavigation = (Button) findViewById(R.id.project_button);
        projectNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProjectScreen();
            }
        });

        //Button creation for navigation between home screen and house style screen
        styleNavigation = (Button) findViewById(R.id.style_button);
        styleNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStyleScreen();
            }
        });

        materialsNavigation = (Button) findViewById(R.id.materials_button);
        materialsNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMaterialsScreen();
            }
        });
    }

    //Method created to be used to navigate to the project
    public void openProjectScreen(){
        Intent navigateToProjectScreen = new Intent(this, Project.class);
        startActivity(navigateToProjectScreen);
    }
    //Method created to be used to navigate to the House Style page
    public void openStyleScreen(){
        Intent navigateToStyleScreen = new Intent(this, Style.class);
        startActivity(navigateToStyleScreen);
    }
    public void openMaterialsScreen(){
        Intent navigateToMaterialsScreen = new Intent(this, Materials.class);
        startActivity(navigateToMaterialsScreen);
    }


}