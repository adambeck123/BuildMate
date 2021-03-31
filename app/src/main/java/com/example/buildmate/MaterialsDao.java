package com.example.buildmate;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MaterialsDao {

    //Inserting the data entered into the EditText boxes on app_project
    @Insert
    void createProject(MaterialsEntity materialsEntity);

    //Query to be used in view_project with the recycler viewer does not contain username
    @Query("Select materialsID, material_name, project_name, house_style, price From MaterialsEntity")
    List<MaterialsEntity> getAllMaterials();

    @Query("Select project_name from ProjectEntity")
    List<String> retrieveProjectName();

    @Query("Select house_style from StyleEntity where project_name = :projectName")
    List<String> getHouseStyle(String projectName);

}

