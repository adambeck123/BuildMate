package com.example.buildmate;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class Materials extends AppCompatActivity {
    private Button materialsButton;
    private MaterialsAdapter materialsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);

        materialsButton = (Button) findViewById(R.id.addMaterials);
        materialsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(Materials.this, AddMaterials.class),100);
            }
        });
        materialsView();
        viewMaterials();
    }
    private RecyclerView materialsRecyclerView;

    private void materialsView() {
        materialsRecyclerView= findViewById(R.id.materialsRecyclerView);
        materialsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Adding line between results
        DividerItemDecoration splitMaterials = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        materialsRecyclerView.addItemDecoration(splitMaterials);
        //Assigning the recycler view with the project adapter, this contains the project_row.xml file
        materialsAdapter = new MaterialsAdapter(this);
        materialsRecyclerView.setAdapter(materialsAdapter);
    }
    private BuildMateDatabase materialsDatabase;
    private void viewMaterials() {
        materialsDatabase = BuildMateDatabase.getBuildMateInstance(this.getApplicationContext());
        List<MaterialsEntity> materials = materialsDatabase.materialsDao().getAllMaterials();
        materialsAdapter.setMaterialsEntityList(materials);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            viewMaterials();
        }
        super.onActivityResult(requestCode, resultCode, data);


    }

}