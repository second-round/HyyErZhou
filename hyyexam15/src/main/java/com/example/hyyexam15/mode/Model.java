package com.example.hyyexam15.mode;


import com.example.hyyexam15.utils.MyCallBack;

import java.util.Map;

public interface Model {
    void setData(String url, Map<String, String> map, Class clazz, MyCallBack myCallBack);
}
