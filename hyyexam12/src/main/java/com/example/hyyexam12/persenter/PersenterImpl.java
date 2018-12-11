package com.example.hyyexam12.persenter;

import android.util.Log;

import com.example.hyyexam12.bean.UserBean;
import com.example.hyyexam12.callback.CallBack;
import com.example.hyyexam12.model.ModelImpl;
import com.example.hyyexam12.view.IView;

public class PersenterImpl implements Persenter{
    private ModelImpl model;
    private IView iView;
    public PersenterImpl(IView iView) {
        this.iView=iView;
        model=new ModelImpl();
    }

    @Override
    public void sendMessage(String s) {
        model.sendMessage(s, new CallBack() {

            @Override
            public void setClass(UserBean o) {
                iView.setClass(o);
            }
        });
    }
}
