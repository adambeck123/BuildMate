package com.example.buildmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Project extends AppCompatActivity {
    private Button viewProject;
    private Button newProject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        viewProject = (Button) findViewById(R.id.viewProjectButton);
        viewProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewProjectScreen();
            }
        });

        newProject = (Button) findViewById(R.id.newProjectButton);
        newProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newProjectScreen();
            }
        });


    }
    public void viewProjectScreen(){
        Intent openViewProjectScreen = new Intent(this, ViewProject.class);
        startActivity(openViewProjectScreen);
    }
    public void newProjectScreen(){
        Intent openNewProjectScreen = new Intent(this, AddProject.class);
        startActivity(openNewProjectScreen);
    }
}