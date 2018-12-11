package com.example.hyyerzhou;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hyyerzhou.adapter.PagerAdater;

public class LoginActivity extends AppCompatActivity {
    private ViewPager pager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pager=findViewById(R.id.pager);
        tabLayout=findViewById(R.id.tab);
        pager.setAdapter(new PagerAdater(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(pager);
    }
}
