package com.example.hyyexam12;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.hyyexam12.bean.UserBean;
import com.example.hyyexam12.persenter.PersenterImpl;
import com.example.hyyexam12.view.IView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {
    private PersenterImpl persenter;
    private Banner banner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        persenter=new PersenterImpl(this);
        banner=findViewById(R.id.banner);
        banner.setImageLoader(new ImageLoaderBnnner());
        persenter.sendMessage("http://www.zhaoapi.cn/ad/getAd");

    }

    @Override
    public void setClass(UserBean userBean) {
        Log.i("TAG",userBean.getMsg());
        List<UserBean.DataBean> data = userBean.getData();
        List<String> list=new ArrayList<>();
        Log.i("TAG",userBean.getMsg());
        for (int i=0;i<data.size();i++){
            String icon = data.get(i).getIcon();
            String substring = icon.substring(0, 4);
            String substring1 = icon.substring(5);
            Log.i("TAG",substring+substring1);
            list.add(substring+substring1);
        }
        banner.setImages(list);
        banner.start();

    }

    private class ImageLoaderBnnner extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            com.nostra13.universalimageloader.core.ImageLoader instance= com.nostra13.universalimageloader.core.ImageLoader.getInstance();
            instance.displayImage((String) path,imageView);
        }
    }
}
