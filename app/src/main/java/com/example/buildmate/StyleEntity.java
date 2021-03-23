package com.example.buildmate;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class StyleEntity {

    //projectID will be used to uniquely define each project customer creates
    @PrimaryKey(autoGenerate = true)
    public int styleID;

    //Columns created for each editable text field available on activity_add_project
    @ColumnInfo(name = "house_style")
    public String houseStyleName;
    @ColumnInfo(name = "number_of_houses")
    public String numberOfHouseStyle;
    @ColumnInfo(name = "project_name")
    public String styleProjectName;
    @ColumnInfo(name = "project_location")
    public String styleProjectLocation;



}
