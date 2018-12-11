package com.example.hyyerzhou.persenter;

import com.example.hyyerzhou.callback.Callback;
import com.example.hyyerzhou.model.ModelImpl;
import com.example.hyyerzhou.view.IView;

public class PersenterImpl implements Persenter{
    private IView iView;
    private ModelImpl model;

    public PersenterImpl(IView iView) {
        this.iView = iView;
        model=new ModelImpl();
    }


    @Override
    public void sendMessage(String path, Class clazz) {
        model.sendMessage(path, clazz, new Callback() {
            @Override
            public void setData(Object o) {
                iView.setData(o);
            }
        });
    }
}
