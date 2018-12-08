package com.example.user.komsi;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    public ArrayList<Item> dataList;

    public ItemAdapter(ArrayList<Item> dataList){
        this.dataList=dataList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemViewHolder holder, int position) {
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtPembuat.setText(dataList.get(position).getPembuat());
        holder.txtTanggal.setText(dataList.get(position).getTanggal());
        holder.txtJam.setText(dataList.get(position).getJam());
    }

    public int getItemCount(){
        return (dataList !=null)? dataList.size():0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtPembuat, txtTanggal, txtJam;

        public ItemViewHolder(View itemView){
            super(itemView);
            txtNama=(TextView) itemView.findViewById(R.id.nama_item);
            txtPembuat=(TextView) itemView.findViewById(R.id.pembuat_item);
            txtTanggal=(TextView) itemView.findViewById(R.id.tanggal_item);
            txtJam=(TextView) itemView.findViewById(R.id.jam_item);
        }
    }

}
