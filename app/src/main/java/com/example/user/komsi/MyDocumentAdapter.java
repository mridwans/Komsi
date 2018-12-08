package com.example.user.komsi;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ASUS on 12/7/2018.
 */

public class MyDocumentAdapter extends RecyclerView.Adapter<MyDocumentAdapter.MyDocumentViewHolder> {
    private ArrayList<MyDocument> dataList;

    public MyDocumentAdapter(ArrayList<MyDocument> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyDocumentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_my_document, parent, false);
        return new MyDocumentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyDocumentAdapter.MyDocumentViewHolder holder, int position) {
        holder.txtFile.setText(dataList.get(position).getFile());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class MyDocumentViewHolder extends RecyclerView.ViewHolder {
        private TextView txtFile;

        public MyDocumentViewHolder(View itemView) {
            super(itemView);
            txtFile = (TextView) itemView.findViewById(R.id.file_my_document);
        }
    }
}
