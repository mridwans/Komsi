package com.example.user.komsi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.AbstractCollection;
import java.util.ArrayList;

public class DataUserAdapter extends RecyclerView.Adapter<DataUserAdapter.DataUserViewHolder> {


    public ArrayList<DataUserModel> dataList;

    public DataUserAdapter(ArrayList<DataUserModel> dataList) {
        this.dataList = dataList;
    }

    @Override
    public DataUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_data_user, parent, false);
        return new DataUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataUserViewHolder holder, int position) {
        holder.txtNamaUser.setText(dataList.get(position).getNamaUser());
        holder.txtNipUser.setText(dataList.get(position).getNipUser());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class DataUserViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNamaUser, txtNipUser;

        public DataUserViewHolder(View itemView) {
            super(itemView);
            txtNamaUser = (TextView) itemView.findViewById(R.id.txt_nama_user);
            txtNipUser = (TextView) itemView.findViewById(R.id.txt_nip_user);
        }
    }
}
