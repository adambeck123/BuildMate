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

public class Style extends AppCompatActivity {
    private Button HouseStyle;
    private StyleAdapter houseStyleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);

        HouseStyle = (Button) findViewById(R.id.newHouseStyle);
        HouseStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(Style.this, AddHouseStyle.class), 100);

            }
        });
        viewHouseStyle();
        houseStyleView();


    }
    private RecyclerView styleRecyclerView;

    private void viewHouseStyle() {
        styleRecyclerView= findViewById(R.id.styleRecyclerView);
        styleRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Adding line between results
        DividerItemDecoration splitHouseStyles = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        styleRecyclerView.addItemDecoration(splitHouseStyles);
        //Assigning the recycler view with the project adapter, this contains the project_row.xml file
        houseStyleAdapter = new StyleAdapter(this);
        styleRecyclerView.setAdapter(houseStyleAdapter);
    }
    private BuildMateDatabase styleDatabase;
    private void houseStyleView() {
        //retrieving the context set in the BuildMateDatabase
        styleDatabase = BuildMateDatabase.getBuildMateInstance(this.getApplicationContext());
        List<StyleEntity> styleEntity = styleDatabase.styleDao().getAllHouseStyles();
        System.out.println(styleEntity);
        houseStyleAdapter.setStyleEntityList(styleEntity);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            viewHouseStyle();
        }
        super.onActivityResult(requestCode, resultCode, data);


    }
}