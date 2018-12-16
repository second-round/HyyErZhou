package com.example.hyyexam15.utils;


import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;

public class OKHttpUtils {
    private static OKHttpUtils instance;
    private Handler handler=new Handler(Looper.getMainLooper());
    private OkHttpClient client;
    public OKHttpUtils() {
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client=new OkHttpClient.Builder()
                .connectTimeout(0,TimeUnit.SECONDS)
                .readTimeout(0,TimeUnit.SECONDS)
                .writeTimeout(0,TimeUnit.SECONDS)
                .build();
    }

    public static OKHttpUtils getInstance() {
        if (instance==null){
            synchronized (OKHttpUtils.class){
                instance=new OKHttpUtils();
            }
        }
        return instance;
    }
    public void postAsynchronization(String url, Map<String,String> params, final Class clazz, final ICallBack iCallBack){
        FormBody.Builder builder=new FormBody.Builder();
//        for (Map.Entry<String,String> entry:params.entrySet()){
//            builder.add(entry.getKey(),entry.getValue());
//        }
//        RequestBody body=builder.build();
        final Request request=new Request.Builder()
                .url(url)
//                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//                iCallBack.failed(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                final Object o = new Gson().fromJson(result, clazz);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iCallBack.success(o);
                    }
                });
            }
        });

    }






}
