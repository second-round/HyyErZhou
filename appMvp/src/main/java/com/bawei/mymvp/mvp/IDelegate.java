package com.bawei.mymvp.mvp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public interface IDelegate {

    void initData();

    void onCreate(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle);

    View getRootView();

    void initContext(Context context);
}
