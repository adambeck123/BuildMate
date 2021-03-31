package com.example.buildmate;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MaterialsEntity {

    //projectID will be used to uniquely define each project customer creates
    @PrimaryKey(autoGenerate = true)
    public int materialsID;

    //Columns created for each editable text field available on activity_add_project
    @ColumnInfo(name = "material_name")
    public String materialstName;
    @ColumnInfo(name = "quantity")
    public String quantiy;
    @ColumnInfo(name = "project_name")
    public String projectName;
    @ColumnInfo(name = "house_style")
    public String houseStyle;
    @ColumnInfo(name = "price")
    public String price;


}
