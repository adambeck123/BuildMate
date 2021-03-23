package com.example.buildmate;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ProjectEntity {

    //projectID will be used to uniquely define each project customer creates
    @PrimaryKey(autoGenerate = true)
    public int projectID;

    //Columns created for each editable text field available on activity_add_project
    @ColumnInfo(name = "project_name")
    public String projectName;
    @ColumnInfo(name = "project_street_location")
    public String projectStreetLocation;
    @ColumnInfo(name = "project_city")
    public String projectCity;
    @ColumnInfo(name = "project_postcode")
    public String projectPostcode;


}
