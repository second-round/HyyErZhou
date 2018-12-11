package com.bawei.mymvp.mvp;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.mymvp.mvp.BaseActivityPresenter;
import com.bawei.mymvp.mvp.MainActivityPresenter;

public class MainActivity extends BaseActivityPresenter<MainActivityPresenter> {

    @Override
    public Class<MainActivityPresenter> getClassDelegate() {
        return MainActivityPresenter.class;
    }


}
