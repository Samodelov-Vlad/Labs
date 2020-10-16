package com.example.labs.ViewModel;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labs.R;
import com.example.labs.model.Calculation;

import java.util.List;
import java.util.Locale;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataHolder> {
    private List<Calculation> listItem;

    public DataAdapter(List<Calculation> list) {
        this.listItem = list;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item , parent, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {
    holder.setData(listItem.get(position));
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    class DataHolder extends RecyclerView.ViewHolder{
    private TextView tv_num1, tv_num2, tv_sum;

        DataHolder(@NonNull View itemView) {
            super(itemView);
            tv_num1 = itemView.findViewById(R.id.tv_num1);
            tv_num2 = itemView.findViewById(R.id.tv_num2);
            tv_sum = itemView.findViewById(R.id.tv_sum);
        }

        void setData(Calculation item){
            tv_num1.setText(String.valueOf(item.num1));
            tv_num2.setText(String.valueOf(item.num2));
            tv_sum.setText(String.format(Locale.getDefault(),"%d + %d = %d", item.num1, item.num2, item.num1+item.num2));
        }
    }



}
