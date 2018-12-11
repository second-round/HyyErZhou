package com.example.day13.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.day13.R;
import com.example.day13.bean.User;
import java.util.ArrayList;
import java.util.List;
public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.ViewHolder> {
    private List<User> list;
    public LinearAdapter() {
        list=new ArrayList<>();
    }
    public void setList(User user) {
        if (user!=null){
            list.add(user);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyle_linear,viewGroup,false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        User user=list.get(i);
        holder.title.setText(user.getName());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        public final TextView title;
        public final ImageView avatar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tv_recycle_linear);
            avatar=itemView.findViewById(R.id.iv_recycle_linear);
        }
    }
}