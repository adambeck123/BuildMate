package com.example.buildmate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StyleAdapter extends RecyclerView.Adapter<StyleAdapter.StyleViewHolder> {

    private Context context;
    private List<StyleEntity> styleEntityList;

    public StyleAdapter(Context context){
        this.context = context;

    }
    public void setStyleEntityList(List<StyleEntity> styleEntityList){

        this.styleEntityList = styleEntityList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    //Creating the view holder with an inflater to display the results of the project_row.xml file
    public StyleAdapter.StyleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View styleView = LayoutInflater.from(context).inflate(R.layout.style_adapter,parent,false);
       return new StyleViewHolder(styleView);
    }


    @Override
    public void onBindViewHolder(@NonNull StyleAdapter.StyleViewHolder holder, int position) {
        holder.houseStyleAdapter.setText(this.styleEntityList.get(position).houseStyleName);
        holder.numberOfHousesAdapter.setText(this.styleEntityList.get(position).numberOfHouseStyle);
        holder.projectNameAdapter.setText(this.styleEntityList.get(position).styleProjectName);
        holder.projectLocationAdapter.setText(this.styleEntityList.get(position).styleProjectLocation);

    }


    @Override
    public int getItemCount() {

        return styleEntityList.size();
    }


    public class StyleViewHolder extends RecyclerView.ViewHolder{
        TextView projectLocationAdapter;
        TextView numberOfHousesAdapter;
        TextView projectNameAdapter;
        TextView houseStyleAdapter;

        public StyleViewHolder(View materialView){
            super(materialView);
            houseStyleAdapter = materialView.findViewById(R.id.houseStyle);
            numberOfHousesAdapter = materialView.findViewById(R.id.numberOfHouses);
            projectNameAdapter = materialView.findViewById(R.id.styleProjectName);
            projectLocationAdapter= materialView.findViewById(R.id.projectLocation);

        }
    }

}
