package com.example.buildmate;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AddMaterials extends AppCompatActivity {
    //BuildMateDatabase styleDatabase = BuildMateDatabase.getBuildMateInstance(this.getApplicationContext());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_materials);
        projectNameDropdown();

    }


    //creating the dropdown for project name
    private void projectNameDropdown(){
        BuildMateDatabase styleDatabase = BuildMateDatabase.getBuildMateInstance(this.getApplicationContext());
        List<String> projectNameList = styleDatabase.materialsDao().retrieveProjectName();
        // Create the spinner
        Spinner projectNameSpinner = (Spinner) findViewById(R.id.materialsNameSpinner);
        //Convert list into array
        String [] projectNameArray= projectNameList.toArray(new String [projectNameList.size()]);
        //Array adapter created to store details of the array
        ArrayAdapter<String> projectNameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, projectNameArray);
        //Layout of the dropdown implemented
        projectNameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter assigned to the spinner
        projectNameSpinner.setAdapter(projectNameAdapter);

    }
    private void houseStyleDropdown(){
        BuildMateDatabase styleDatabase = BuildMateDatabase.getBuildMateInstance(this.getApplicationContext());
        List<String> houseStyleList = styleDatabase.materialsDao().getHouseStyle();
        // Create the spinner
        Spinner houseStyleSpinner = (Spinner) findViewById(R.id.houseStyleSpinner);
        //Convert list into array
        String [] houseStyleArray= houseStyleList.toArray(new String [houseStyleList.size()]);
        //Array adapter created to store details of the array
        ArrayAdapter<String> houseStyleAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, houseStyleArray);
        //Layout of the dropdown implemented
        houseStyleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter assigned to the spinner
        houseStyleSpinner.setAdapter(houseStyleAdapter);

    }

    }

    /*
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
*/
