package com.example.buildmate;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StyleDao {

    //Inserting the data entered into the EditText boxes on app_project
    @Insert
    void createProject(StyleEntity styleEntity);

    //Query to be used in view_project with the recycler viewer does not contain username
    @Query("Select styleID, house_style, number_of_houses, project_name, project_location From StyleEntity")
    List<StyleEntity> getAllHouseStyles();


}
