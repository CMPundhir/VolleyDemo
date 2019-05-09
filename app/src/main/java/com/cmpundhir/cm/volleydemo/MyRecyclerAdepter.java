package com.cmpundhir.cm.volleydemo;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cmpundhir.cm.volleydemo.model.GithubUserPojo;

import java.util.List;

import butterknife.BindView;

public class MyRecyclerAdepter extends RecyclerView.Adapter<MyRecyclerAdepter.ViewHolder> {
    Activity context;
    List<GithubUserPojo> list;
    public MyRecyclerAdepter(Activity context,List<GithubUserPojo> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =context.getLayoutInflater().inflate(R.layout.item,parent,false);
        ViewHolder holder =new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GithubUserPojo pojoData = list.get(position);
//        holder.name.setText(pojoData.getName());
//        holder.location.setText(pojoData.getLocation());
//        holder.company.setText(pojoData.getCompany());
        holder.login.setText(pojoData.getLogin());
        Glide.with(context).load(pojoData.getAvatarUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //TextView name,location,company;
        TextView login;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            name = itemView.findViewById(R.id.nameTxt);
//            location = itemView.findViewById(R.id.locationTxt);
            login= itemView.findViewById(R.id.loginTxt);
            //company = itemView.findViewById(R.id.companyNameTxt);
            img = itemView.findViewById(R.id.image1);
        }

    }
}
