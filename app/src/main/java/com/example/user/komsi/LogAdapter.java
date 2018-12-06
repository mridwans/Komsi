package com.example.user.komsi;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.LogViewHolder> {
    private ArrayList<Log> dataList;

    public LogAdapter(ArrayList<Log> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public LogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_log, parent, false);
        return new LogViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull LogAdapter.LogViewHolder holder, int position) {
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtKegiatan.setText(dataList.get(position).getKegiatan());
        holder.txtTanggal.setText(dataList.get(position).getTanggal());
        holder.txtJam.setText(dataList.get(position).getJam());

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class LogViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNama, txtKegiatan, txtTanggal, txtJam;

        public LogViewHolder(View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.nama_log);
            txtKegiatan = (TextView) itemView.findViewById(R.id.kegiatan_log);
            txtTanggal = (TextView) itemView.findViewById(R.id.tanggal_log);
            txtJam = (TextView) itemView.findViewById(R.id.jam_log);
        }
    }
}
