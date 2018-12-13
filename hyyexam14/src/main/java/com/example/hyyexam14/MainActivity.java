package com.example.hyyexam14;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<MyImages> list;
    private ValueAnimator animator;
    private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=0;
        list=new ArrayList<>();
        MyImages myImages=findViewById(R.id.image1);
        MyImages myImages1=findViewById(R.id.image2);
        MyImages myImages2=findViewById(R.id.image3);
        MyImages myImages3=findViewById(R.id.image4);
        MyImages myImages4=findViewById(R.id.image5);
        MyImages myImages5=findViewById(R.id.image6);
        MyImages myImages6=findViewById(R.id.image7);
        MyImages myImages7=findViewById(R.id.image8);
        MyImages myImages8=findViewById(R.id.image9);
        list.add(myImages);
        list.add(myImages1);
        list.add(myImages2);
        list.add(myImages3);
        list.add(myImages4);
        list.add(myImages5);
        list.add(myImages6);
        list.add(myImages7);
        list.add(myImages8);
        getData(i);


    }

    private void getData(final int i) {
        animator=ValueAnimator.ofInt(Color.parseColor("#00ff00"),Color.parseColor("#ffff00"));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int color= (int) animation.getAnimatedValue();
                list.get(i).setBackgroundColor(color);


            }
        });
        animator.setDuration(1000);
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();
        if (i==8){
            getDatas(i);
            return;
        }
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                getData(i+1);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });

    }
    private void getDatas(final int i) {
        animator=ValueAnimator.ofInt(Color.parseColor("#ffff00"),Color.parseColor("#00ff00"));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int color= (int) animation.getAnimatedValue();
                list.get(i).setBackgroundColor(color);
            }
        });
        animator.setDuration(1000);
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();
        if (i==0){
            getData(i);
            return;
        }
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                getDatas(i-1);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });

    }
}
