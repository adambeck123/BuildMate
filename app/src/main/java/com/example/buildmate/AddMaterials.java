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

public class AddMaterials extends AppCompatActivity {
    //BuildMateDatabase styleDatabase = BuildMateDatabase.getBuildMateInstance(this.getApplicationContext());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_materials);
        projectNameDropdown();

        final EditText nameOfMaterials = findViewById(R.id.nameOfMaterials);
        final EditText quantity = findViewById(R.id.materialQuantity);
        final EditText price = findViewById(R.id.price);
        Button materialsSubmitButton = findViewById(R.id.materialsSubmitButton);
        materialsSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMaterialsToDatabase(nameOfMaterials.getText().toString(), quantity.getText().toString(),price.getText().toString(),materialsProjectName,houseStyleDropdown);
            }
        });
    }

    private void addMaterialsToDatabase(String nameOfMaterials, String quantity, String price, String projectName, String houseStyle) {
        BuildMateDatabase materialsDatabase = BuildMateDatabase.getBuildMateInstance(this.getApplicationContext());
        MaterialsEntity materialsEntity = new MaterialsEntity();
        materialsEntity.materialstName = nameOfMaterials;
        materialsEntity.quantiy = quantity;
        materialsEntity.price = price;
        materialsEntity.projectName = projectName;
        materialsEntity.houseStyle = houseStyle;
        materialsDatabase.materialsDao().createProject(materialsEntity);
        finish();
        System.out.println("success");

    }


    String materialsProjectName = null;
    //creating the dropdown for project name
    private void projectNameDropdown(){
        BuildMateDatabase styleDatabase = BuildMateDatabase.getBuildMateInstance(this.getApplicationContext());
        List<String> projectNameList = styleDatabase.materialsDao().retrieveProjectName();
        // Create the spinner
        Spinner projectNameSpinner = (Spinner) findViewById(R.id.materialsNameSpinner);
        projectNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                materialsProjectName = parent.getItemAtPosition(position).toString();
                houseStyleDropdown(materialsProjectName);
                System.out.println(materialsProjectName);
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

    String houseStyleDropdown = null;
    private void houseStyleDropdown(String ProjectName){
        BuildMateDatabase styleDatabase = BuildMateDatabase.getBuildMateInstance(this.getApplicationContext());
        String projectName = ProjectName;
        List<String> houseStyleList = styleDatabase.materialsDao().getHouseStyle(projectName);
        // Create the spinner
        Spinner houseStyleSpinner = (Spinner) findViewById(R.id.houseStyleSpinner);

       houseStyleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               houseStyleDropdown = parent.getItemAtPosition(position).toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
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
