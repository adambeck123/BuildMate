package com.example.buildmate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MaterialsAdapter extends RecyclerView.Adapter<MaterialsAdapter.MaterialsViewHolder> {

    private Context context;
    private List<MaterialsEntity> materialsEntityList;

    public MaterialsAdapter(Context context){
        this.context = context;

    }
    public void setMaterialsEntityList(List<MaterialsEntity> materialsEntityList){

        this.materialsEntityList = materialsEntityList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    //Creating the view holder with an inflater to display the results of the project_row.xml file
    public MaterialsAdapter.MaterialsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View materialView = LayoutInflater.from(context).inflate(R.layout.material_adapter,parent,false);
       return new MaterialsViewHolder(materialView);
    }

    @Override
    public void onBindViewHolder(@NonNull MaterialsAdapter.MaterialsViewHolder holder, int position) {
        holder.materialNameAdapter.setText(this.materialsEntityList.get(position).materialstName);
        holder.quantityAdapter.setText(this.materialsEntityList.get(position).quantiy);
        holder.priceAdapter.setText(this.materialsEntityList.get(position).price);
        holder.projectNameAdapter.setText(this.materialsEntityList.get(position).projectName);
        holder.houseStyleAdapter.setText(this.materialsEntityList.get(position).houseStyle);


    }

    @Override
    public int getItemCount() {

        return materialsEntityList.size();
    }


    public class MaterialsViewHolder extends RecyclerView.ViewHolder{
        TextView materialNameAdapter;
        TextView quantityAdapter;
        TextView projectNameAdapter;
        TextView houseStyleAdapter;
        TextView priceAdapter;

        public MaterialsViewHolder(View materialView){
            super(materialView);
            materialNameAdapter = materialView.findViewById(R.id.materialName);
            quantityAdapter = materialView.findViewById(R.id.quantityView);
            projectNameAdapter = materialView.findViewById(R.id.materialsProjectName);
            houseStyleAdapter= materialView.findViewById(R.id.houseStyle);
            priceAdapter = materialView.findViewById(R.id.price);
        }
    }

}
