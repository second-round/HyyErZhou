package com.example.hyyerzhou.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hyyerzhou.R;
import com.example.hyyerzhou.ZxingActivity;
import com.example.hyyerzhou.adapter.Adapter;
import com.example.hyyerzhou.bean.UserBean;
import com.example.hyyerzhou.persenter.PersenterImpl;
import com.example.hyyerzhou.view.IView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import me.maxwin.view.XListView;

public class FragmentHead extends Fragment implements IView {
    private TextView textView3;
    private PersenterImpl persenter;
    private Banner banner;
    private XListView xListView;
    private Adapter adapter;
    private int page;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_head,container,false);
        textView3=view.findViewById(R.id.textView3);
        persenter=new PersenterImpl(this);
        banner=view.findViewById(R.id.bnner);
        xListView=view.findViewById(R.id.xlist);
        page=1;
        xListView.setPullRefreshEnable(true);
        adapter=new Adapter(getActivity());
        xListView.setPullLoadEnable(true);
        xListView.setAdapter(adapter);
        persenter.sendMessage("http://www.zhaoapi.cn/home/getHome",UserBean.class);
        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                page=1;
                persenter.sendMessage("http://www.zhaoapi.cn/home/getHome",UserBean.class);
            }

            @Override
            public void onLoadMore() {
                persenter.sendMessage("http://www.zhaoapi.cn/home/getHome",UserBean.class);
            }
        });
        banner.setImageLoader(new ImageLoderBanner());
        ArrayList<String> list = new ArrayList<>();
        list.add("http://img02.store.sogou.com/app/a/10010016/872a3aea2cb3a3ec0f93168a8bfdb3b5");
        list.add("http://img03.store.sogou.com/app/a/10010016/9b34d9c0f1f507365fd89288a116fa57");
        list.add("http://img04.store.sogou.com/app/a/10010016/74786309c1ef489a38f92cbba70a4ad8");
        banner.setImages(list);
        banner.start();
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ZxingActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void setData(Object o) {
        UserBean userBean= (UserBean) o;
        String name = userBean.getData().getMiaosha().getList().get(1).getTitle();
        Toast.makeText(getActivity(),name,Toast.LENGTH_LONG).show();
        if (page==1){
            adapter.setListBeans(userBean.getData().getMiaosha().getList());
        }else {
            adapter.addListBeans(userBean.getData().getMiaosha().getList());
        }
        page++;
        xListView.stopLoadMore();
        xListView.stopRefresh();
    }
    private class ImageLoderBanner extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            com.nostra13.universalimageloader.core.ImageLoader instance = com.nostra13.universalimageloader.core.ImageLoader.getInstance();
            instance.displayImage((String) path, imageView);
        }
    }
}