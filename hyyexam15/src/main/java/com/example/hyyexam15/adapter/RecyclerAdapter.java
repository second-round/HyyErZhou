package com.example.hyyexam15.adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.hyyexam15.R;
import com.example.hyyexam15.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Context context;
    private List<UserBean.DataBean> phone;
    public RecyclerAdapter(Context context) {
        this.context = context;
        phone=new ArrayList<>();
    }

    public void setPhone(List<UserBean.DataBean> phone) {
        this.phone = phone;
        notifyDataSetChanged();
    }
    public void addPhone(List<UserBean.DataBean> phone) {
        this.phone .addAll(phone);
        notifyDataSetChanged();
    }

    public List<UserBean.DataBean> getPhone() {
        return phone;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View v=View.inflate(context,R.layout.item_one,null);
        ViewHolder holder=new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.textView.setText(phone.get(i).getTitle());
        viewHolder.textView2.setText(phone.get(i).getAuthor_name());
        Glide.with(context).load(phone.get(i).getThumbnail_pic_s()).into(viewHolder.imageView);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener!=null){
                    clickListener.onitemClick(v,i);
                }
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (longItemClickListener!=null){
                    longItemClickListener.onItemLongClick(v,i);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return phone.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView,textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            textView2=itemView.findViewById(R.id.textView2);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }


    //接口回调,条目点击事件

    public interface OnItemClickListener{
        void onitemClick(View item, int position);
    }
    public interface OnLongItemClickListener {
        void onItemLongClick(View itemView, int position);
    }
    private OnLongItemClickListener longItemClickListener;
    private OnItemClickListener clickListener;

    public void setOnItemClickListener(OnItemClickListener clickListener){
        this.clickListener=clickListener;
    }
    public void setOnLongItemClickListener(OnLongItemClickListener longItemClickListener){
        this.longItemClickListener=longItemClickListener;
    }






















}
