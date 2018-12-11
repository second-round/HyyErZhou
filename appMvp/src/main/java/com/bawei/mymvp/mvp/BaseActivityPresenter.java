package com.bawei.mymvp.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class BaseActivityPresenter<T extends AppDelegate> extends Activity{
    public T dalegate;
    public abstract Class<T> getClassDelegate();
    public BaseActivityPresenter() {
        try {
            dalegate = getClassDelegate().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dalegate.onCreate(getLayoutInflater(), null, savedInstanceState);
        setContentView(dalegate.getRootView());
        dalegate.initContext(this);
        dalegate.initData();
    }
}
