package com.example.hyyerzhou.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.hyyerzhou.fragment.FragmentHead;
import com.example.hyyerzhou.fragment.FragmentOther;

public class PagerAdater extends FragmentPagerAdapter {
    private String[] s={"首页","分类","觅Me","购物车","我的"};

    public PagerAdater(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new FragmentHead();
            default:
                return new FragmentOther();
        }
    }

    @Override
    public int getCount() {
        return s.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return s[position];
    }
}
