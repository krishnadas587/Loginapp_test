package com.example.login_page.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login_page.Models.Database_babk_model;
import com.example.login_page.R;
import com.example.login_page.database.bankdb;

import java.util.ArrayList;
import java.util.List;

public class Recycle_adapter extends RecyclerView.Adapter<Recycle_adapter.viewholder>{
    Context ctx;
    List<String> dbm_name=new ArrayList<>();
    List<Integer> dbm_amount=new ArrayList<>();
    bankdb ddb;

    public Recycle_adapter(Context ctx, List<String> dbm_name, List<Integer> dbm_amount) {
        this.ctx = ctx;
        this.dbm_name = dbm_name;
        this.dbm_amount = dbm_amount;
        ddb=new bankdb(ctx);
    }

    @NonNull
    @Override
    public Recycle_adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.financial_info, null, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recycle_adapter.viewholder holder, int position) {
        for (String ddd : dbm_name){
            System.out.println("jknd "+ddd);
        }
        holder.branch.setText(dbm_name.get(position).toString());
        holder.price.setText(dbm_amount.get(position).toString());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ddb.deletebranch(holder.branch.getText().toString());
                dbm_name.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, dbm_name.size());

            }
        });
holder.edit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        System.out.println(holder.branch.getText().toString()+"  "+holder.price.getText().toString()+"  "+position);
        if(ddb.update(dbm_name.get(position),holder.branch.getText().toString()) && ddb.update(dbm_amount.get(position).toString(),holder.price.getText().toString())){
            notifyItemChanged(position);
        }


    }
});
    }

    @Override
    public int getItemCount() {
        return dbm_name.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        EditText branch,price;
        ImageView edit,delete;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            branch=itemView.findViewById(R.id.branch_holder);
            price=itemView.findViewById(R.id.price_holder);
            edit=itemView.findViewById(R.id.edit_image);
            delete=itemView.findViewById(R.id.delete_image);
        }
    }
}
