package com.example.buildmate;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ProjectEntity.class, StyleEntity.class, MaterialsEntity.class}, version = 1)


public abstract class BuildMateDatabase extends RoomDatabase {


    public abstract ProjectDao projectDao ();
    public abstract StyleDao styleDao();
    public abstract MaterialsDao materialsDao ();
    //Creating instance of the BuildMateDatabase
    private static BuildMateDatabase BuildMateInstance;
    public static BuildMateDatabase getBuildMateInstance(Context context){
        //If the instance is not already created, it will create a new database named BuildMateDatabase
        //Otherwise will return the instance previously created
        if(BuildMateInstance == null){
            BuildMateInstance = Room.databaseBuilder(context.getApplicationContext(),BuildMateDatabase.class, "BuildMateDatabase")
                    .allowMainThreadQueries().build();


        }
        return BuildMateInstance;
    }



}