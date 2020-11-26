package com.example.buildmate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddProject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);

        final EditText newProjectName = findViewById(R.id.newProjectName);
        final EditText newStreetLocation = findViewById(R.id.newStreetLocation);
        final EditText newCity = findViewById(R.id.newCity);
        final EditText newPostcode = findViewById(R.id.newPostcode);
        final String username = "User1";
        Button projectSubmitButton = findViewById(R.id.projectSubmitButton);
        projectSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProjectToDatabase(newProjectName.getText().toString(), newStreetLocation.getText().toString(),newCity.getText().toString(),newPostcode.getText().toString(),username );
            }
        });
    }

    private void addProjectToDatabase(String projectName, String streetLocation, String city, String postcode, String username) {
        BuildMateDatabase projectDatabase = BuildMateDatabase.getBuildMateInstance(this.getApplicationContext());
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.projectName = projectName;
        projectEntity.projectStreetLocation = streetLocation;
        projectEntity.projectCity =city;
        projectEntity.projectPostcode = postcode;
        projectDatabase.projectDao().createProject(projectEntity);

        finish();

    }

}