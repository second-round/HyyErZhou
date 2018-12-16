package com.example.hyyexam15.persenter;

import com.example.hyyexam15.mode.ModelImpl;
import com.example.hyyexam15.utils.MyCallBack;
import com.example.hyyexam15.view.IView;

import java.util.Map;

public class PersenterImpl implements Persenter{
    private IView iView;
    private ModelImpl model;

    public PersenterImpl(IView iView) {
        this.iView = iView;
        model=new ModelImpl();
    }

    @Override
    public void sendMessage(String url, final Map<String, String> map, Class clazz) {
        model.setData(url, map, clazz, new MyCallBack() {
            @Override
            public void setData(Object o) {
                iView.showResponseData(o);
            }
        });
    }
}
