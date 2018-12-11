package com.example.hyyexam12.model;


import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import com.example.hyyexam12.bean.UserBean;
import com.example.hyyexam12.callback.CallBack;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ModelImpl implements Model{
    @SuppressLint("StaticFieldLeak")
    @Override
    public void sendMessage(String s, final CallBack callBack) {
        new AsyncTask<String, Void, UserBean>() {
            @Override
            protected UserBean doInBackground(String... strings) {
                try {
                    URL url=new URL(strings[0]);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setConnectTimeout(5000);
                    urlConnection.setReadTimeout(5000);
                    int responseCode = urlConnection.getResponseCode();
                    if (responseCode==200){
                        String s=stream2string(urlConnection.getInputStream());
                        UserBean userBean = new Gson().fromJson(s, UserBean.class);
                        Log.i("TAG",s);
                        Log.i("TAG",userBean.getData().get(1).getTitle());
                        return userBean;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(UserBean o) {
                super.onPostExecute(o);
                callBack.setClass(o);
            }
        }.execute(s);
    }

    private String stream2string(InputStream inputStream) throws IOException {
        InputStreamReader reader=new InputStreamReader(inputStream);
        BufferedReader bf=new BufferedReader(reader);
        StringBuilder builder=new StringBuilder();
        for (String emp=bf.readLine();emp!=null;emp=bf.readLine()){
            builder.append(emp);
        }
        return builder.toString();
    }
}
