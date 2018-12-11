package com.bawei.mymvp.mvp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.mymvp.R;

public class MainActivityPresenter extends AppDelegate {
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        super.initData();

        TextView text = get(R.id.text);
        text.setText("123123123123123123");
    }

    @Override
    public void onCreate(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(inflater, viewGroup, bundle);
    }

    @Override
    public View getRootView() {
        return super.getRootView();
    }

    @Override
    public void initContext(Context context) {
        super.initContext(context);
    }
}
