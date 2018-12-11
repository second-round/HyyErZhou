package com.example.hyyerzhou.model;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.example.hyyerzhou.callback.Callback;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ModelImpl implements Model{
    @SuppressLint("StaticFieldLeak")
    @Override
    public void sendMessage(String path, final Class clazz, final Callback callback) {
        new AsyncTask<String, Void, Object>() {
            @Override
            protected Object doInBackground(String... strings) {
                try {
                    URL url=new URL(strings[0]);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setReadTimeout(5000);
                    urlConnection.setConnectTimeout(5000);
                    int responseCode = urlConnection.getResponseCode();
                    if (responseCode==200){
                        String s=stream2string(urlConnection.getInputStream());
                        Object o = new Gson().fromJson(s, clazz);
                        return o;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                callback.setData(o);
            }
        }.execute(path);
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
