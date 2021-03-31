package com.example.buildmate;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AddHouseStyle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_housestyle);
        projectNameDropdown();
        //projectLocationDropdown();

        final EditText newHouseStyleName = findViewById(R.id.newHouseStyleName);
        final EditText numberOfHouses = findViewById(R.id.numberOfHouses);
        Button houseStyleSubmitButton = findViewById(R.id.houseStyleSubmitButton);
        houseStyleSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addHouseStyleToDatabase(newHouseStyleName.getText().toString(), numberOfHouses.getText().toString(),projectName,projectLocation);
            }
        });
    }

    private void addHouseStyleToDatabase(String houseStyleName, String numberOfHouses, String projectName, String projectLocation) {
        BuildMateDatabase styleDatabase = BuildMateDatabase.getBuildMateInstance(this.getApplicationContext());
        StyleEntity styleEntity = new StyleEntity();
        styleEntity.houseStyleName = houseStyleName;
        styleEntity.numberOfHouseStyle = numberOfHouses;
        styleEntity.styleProjectName = projectName;
        styleEntity.styleProjectLocation = projectLocation;
        styleDatabase.styleDao().createProject(styleEntity);
        finish();


    }

    String projectName = null;
    //creating the dropdown for project name
    private void projectNameDropdown(){
        BuildMateDatabase styleDatabase = BuildMateDatabase.getBuildMateInstance(this.getApplicationContext());
        List<String> projectNameList = styleDatabase.styleDao().getProjectName();
        // Create the spinner
        Spinner projectNameSpinner = (Spinner) findViewById(R.id.projectNameSpinner);

        projectNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                projectName = parent.getItemAtPosition(position).toString();
                projectLocationDropdown(projectName);
                System.out.println(projectName);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Convert list into array
        String [] projectNameArray= projectNameList.toArray(new String [projectNameList.size()]);
        //Array adapter created to store details of the array
        ArrayAdapter<String> projectNameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, projectNameArray);
        //Layout of the dropdown implemented
        projectNameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter assigned to the spinner
        projectNameSpinner.setAdapter(projectNameAdapter);
    }


    String projectLocation = null;
    private void projectLocationDropdown(String ProjectName){
        BuildMateDatabase styleDatabase = BuildMateDatabase.getBuildMateInstance(this.getApplicationContext());
        String projectName = ProjectName;
        List<String> projectLocationList = styleDatabase.styleDao().getProjectLocation(projectName);

        // Create the spinner
        Spinner projectLocationSpinner = (Spinner) findViewById(R.id.projectLocationSpinner);

        // Setting the listener for the dropdown and storing the selected item as a string.
        projectLocationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                projectLocation = parent.getItemAtPosition(position).toString();
                System.out.println(projectLocation);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //Convert list into array
        String [] projectLocationArray= projectLocationList.toArray(new String [projectLocationList.size()]);
        //Array adapter created to store details of the array
        ArrayAdapter<String> projectLocationAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, projectLocationArray);
        //Layout of the dropdown implemented
        projectLocationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter assigned to the spinner
        projectLocationSpinner.setAdapter(projectLocationAdapter);
    }

}