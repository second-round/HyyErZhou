package com.example.hyyexam13.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hyyexam13.R;
import com.example.hyyexam13.adapter.GridAdapter;
import com.example.hyyexam13.bean.UserBean;
import com.example.hyyexam13.persenter.PersenterImpl;
import com.example.hyyexam13.view.IView;

import java.util.HashMap;
import java.util.Map;

public class FragmentGrid extends Fragment implements IView {
    private PersenterImpl persenter;
    private final int ITEM_COUNT=2;
    private String url="http://www.zhaoapi.cn/product/getCatagory";
    private RecyclerView grid_view;
    private GridAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_grid,container,false);
        persenter=new PersenterImpl(this);
        grid_view=v.findViewById(R.id.recycle);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),ITEM_COUNT);
        gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        grid_view.setLayoutManager(gridLayoutManager);
        adapter = new GridAdapter(getActivity());
        grid_view.setAdapter(adapter);
        Map<String,String> map=new HashMap<>();
        map.put("name","");
        DividerDecoration dividerDecoration=new DividerDecoration(getActivity());
        grid_view.addItemDecoration(dividerDecoration);
        persenter.sendMessage(url,map,UserBean.class);
        return v;
    }
    @Override
    public void success(Object oj) {
        UserBean userBean= (UserBean) oj;
        String name = userBean.getData().get(1).getName();
        adapter.setList(userBean.getData());


    }

    @Override
    public void file(Exception e) {

    }
}