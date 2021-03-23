package com.example.buildmate;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProjectDao {

    //Inserting the data entered into the EditText boxes on app_project
    @Insert
    void createProject(ProjectEntity projectEntity);

    //Query to be used in view_project with the recycler viewer does not contain username
    @Query("Select projectID, project_name, project_street_location, project_city, project_postcode From ProjectEntity")
    List<ProjectEntity> getAllProjects();


}
