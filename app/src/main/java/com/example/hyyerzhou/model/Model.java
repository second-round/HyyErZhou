package com.example.hyyerzhou.model;

import com.example.hyyerzhou.bean.LoginBean;
import com.example.hyyerzhou.callback.Callback;

public interface Model {
    void sendMessage(String path, Class clazz, Callback callback);
}
