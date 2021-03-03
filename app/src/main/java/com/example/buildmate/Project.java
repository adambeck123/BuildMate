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

public class Project extends AppCompatActivity {
    private Button newProject;
    private ViewProjectAdapter projectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        //Initialize Project Button for navigation created
        newProject = (Button) findViewById(R.id.newProjectButton);
        newProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(Project.this, AddProject.class), 100);
            }
        });

        projectView();
        viewProject();

    }
    private RecyclerView projectRecyclerView;
    private void projectView(){

        // Initializing the RecyclerView
        projectRecyclerView= findViewById(R.id.projectRecyclerView);
        projectRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Adding line between results
        DividerItemDecoration splitProjects = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        projectRecyclerView.addItemDecoration(splitProjects);
        //Assigning the recycler view with the project adapter, this contains the project_row.xml file
        projectAdapter = new ViewProjectAdapter(this);
        projectRecyclerView.setAdapter(projectAdapter);

    }
    private BuildMateDatabase projectDatabase;
    private void viewProject(){
        //retrieving the context set in the BuildMateDatabase
        projectDatabase = BuildMateDatabase.getBuildMateInstance(this.getApplicationContext());
        //
        List<ProjectEntity> projects = projectDatabase.projectDao().getAllProjects();
        projectAdapter.setProjectEntityList(projects);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            viewProject();
        }
            super.onActivityResult(requestCode, resultCode, data);


    }

}