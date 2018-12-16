package com.example.hyyexam15;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hyyexam15.adapter.RecyclerAdapter;
import com.example.hyyexam15.bean.UserBean;
import com.example.hyyexam15.persenter.PersenterImpl;
import com.example.hyyexam15.view.IView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements IView {
    private String path="http://www.xieast.com/api/news/news.php?page=";
    private PersenterImpl persenter;
    private XRecyclerView xRecyclerView;
    private int page;
    private ImageView imageView,img;
    private Map<String,String> map;
    private RecyclerAdapter adapter;
    private List<UserBean.DataBean> phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        load();
    }
    private void init() {
        page=1;
        persenter=new PersenterImpl(this);
        xRecyclerView=findViewById(R.id.recycle);
        imageView=findViewById(R.id.image);
        img=findViewById(R.id.img);
        LinearLayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);
        xRecyclerView.setPullRefreshEnabled(true);
        xRecyclerView.setLoadingMoreEnabled(true);
        adapter=new RecyclerAdapter(MainActivity.this);
        xRecyclerView.setAdapter(adapter);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                load();
            }

            @Override
            public void onLoadMore() {
                load();
            }
        });
        adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onitemClick(final View item, final int position) {
                phone = adapter.getPhone();
                ObjectAnimator alpha = ObjectAnimator.ofFloat(item, "alpha", 1f, 0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(3000);
                animatorSet.playTogether( alpha);
                animatorSet.start();
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationCancel(Animator animation) {
                        super.onAnimationCancel(animation);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        phone.remove(position);
                        adapter.notifyDataSetChanged();
                        item.setAlpha(1.0f);
                    }

                    @Override
                    public void onAnimationStart(Animator animation) {
                        super.onAnimationStart(animation);
                    }
                });
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"aaa",Toast.LENGTH_LONG).show();
                ObjectAnimator translation_X = ObjectAnimator.ofFloat(imageView, "translationX", 0,-1000);
                //Y轴平移
                ObjectAnimator translation_Y = ObjectAnimator.ofFloat(imageView, "translationY", 0,2000);
                ObjectAnimator alpha = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(3000);
                animatorSet.playTogether(translation_X, translation_Y, alpha);
                animatorSet.start();
                img.setVisibility(View.GONE);
                imageView.setBackgroundResource(R.drawable.check);
            }
        });


    }
    private void load() {
        Log.i("TAG",page+"");
        map=new HashMap<>();
        map.put("page",page+"");
        persenter.sendMessage(path+page,map,UserBean.class);
    }
    @Override
    public void showResponseData(Object oj) {
        UserBean userBean= (UserBean) oj;
        if (page==1){
            adapter.setPhone(userBean.getData());
        }else {
            adapter.addPhone(userBean.getData());
        }
        page++;
        xRecyclerView.refreshComplete();
        xRecyclerView.loadMoreComplete();
    }
}