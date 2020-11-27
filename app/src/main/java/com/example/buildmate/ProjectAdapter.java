package com.example.buildmate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    private Context context;
    private List<ProjectEntity> projectEntityList;

    public ProjectAdapter(Context context){
        this.context = context;

    }
    public void setProjectEntityList(List<ProjectEntity> projectEntityList){

        this.projectEntityList = projectEntityList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProjectAdapter.ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View projectView = LayoutInflater.from(context).inflate(R.layout.project_row,parent,false);
       return new ProjectViewHolder(projectView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectAdapter.ProjectViewHolder holder, int position) {
        holder.projectNameRow.setText(this.projectEntityList.get(position).projectName);
        holder.streetLocationRow.setText(this.projectEntityList.get(position).projectStreetLocation);
        holder.cityRow.setText(this.projectEntityList.get(position).projectCity);
        holder.postcodeRow.setText(this.projectEntityList.get(position).projectPostcode);

    }

    @Override
    public int getItemCount() {
        return projectEntityList.size();
    }

    public class ProjectViewHolder extends RecyclerView.ViewHolder{
        TextView projectNameRow;
        TextView streetLocationRow;
        TextView cityRow;
        TextView postcodeRow;

        public ProjectViewHolder(View projectView){
            super(projectView);
            projectNameRow = projectView.findViewById(R.id.projectNameRow);
            streetLocationRow = projectView.findViewById(R.id.streetLocationRow);
            cityRow = projectView.findViewById(R.id.cityRow);
            postcodeRow= projectView.findViewById(R.id.postcodeRow);

        }
    }

}
