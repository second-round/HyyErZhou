package com.example.hyyexam15.mode;

import com.example.hyyexam15.utils.ICallBack;
import com.example.hyyexam15.utils.MyCallBack;
import com.example.hyyexam15.utils.OKHttpUtils;

import java.util.Map;

public class ModelImpl implements Model {
    @Override
    public void setData(String url, Map<String, String> map, Class clazz, final MyCallBack myCallBack) {

        OKHttpUtils.getInstance().postAsynchronization(url, map, clazz, new ICallBack() {
            @Override
            public void success(Object oj) {
                myCallBack.setData(oj);
            }

            @Override
            public void failed(Exception e) {
                myCallBack.setData(e.toString());
            }
        });
    }
}
