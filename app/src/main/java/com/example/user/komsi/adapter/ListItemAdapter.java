package com.example.user.komsi.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.komsi.R;
import com.example.user.komsi.model.ListItemModel;

import java.util.ArrayList;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ListItemViewHolder> {
    public ArrayList<ListItemModel> dataList;

    public ListItemAdapter(ArrayList<ListItemModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_list_item, parent, false);
        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder holder, int position) {
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtPembuat.setText(dataList.get(position).getPembuat());
        holder.txtTanggal.setText(dataList.get(position).getTanggal());
        holder.txtJam.setText(dataList.get(position).getJam());
    }

    @Override
    public int getItemCount() {
        return (dataList !=null)? dataList.size():0;
    }

    public class ListItemViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNama, txtPembuat, txtTanggal, txtJam;

        public ListItemViewHolder(View itemView){
            super(itemView);
            txtNama=(TextView) itemView.findViewById(R.id.nama_item);
            txtPembuat=(TextView) itemView.findViewById(R.id.pembuat_item);
            txtTanggal=(TextView) itemView.findViewById(R.id.tanggal_item);
            txtJam=(TextView) itemView.findViewById(R.id.jam_item);
        }
    }
}
