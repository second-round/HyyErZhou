package com.bawei.mymvp.mvp;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class AppDelegate implements IDelegate {
    private View mRootView;
    private Context mContext;

    @Override
    public void initData() {

    }

    @Override
    public void onCreate(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        mRootView = inflater.inflate(getLayoutId(), viewGroup, false);
    }

    public abstract int getLayoutId();

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public void initContext(Context context) {
        mContext = context;
    }

    private SparseArray<View> views=new SparseArray<>();

    public <T extends View> T get(int id){
        T view= (T) views.get(id);
        if(view==null){
            view = mRootView.findViewById(id);
            views.put(id,view);
        }
        return view;
    }
}
