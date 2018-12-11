package com.example.hyyerzhou.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hyyerzhou.R;
import com.example.hyyerzhou.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends BaseAdapter {
    private List<UserBean.DataBean.MiaoshaBean.ListBean> listBeans;
    private Context context;

    public Adapter(Context context) {
        this.context = context;
        listBeans=new ArrayList<>();
    }

    public void setListBeans(List<UserBean.DataBean.MiaoshaBean.ListBean> listBeans) {
        listBeans.clear();
        this.listBeans.addAll(listBeans);
        notifyDataSetChanged();
    }

    public void addListBeans(List<UserBean.DataBean.MiaoshaBean.ListBean> listBeans) {
        this.listBeans.addAll(listBeans);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return listBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.item,parent,false);
            holder=new ViewHolder();
            holder.textView=convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(listBeans.get(position).getTitle());
        return convertView;
    }
    class ViewHolder{
        TextView textView;
    }
}
