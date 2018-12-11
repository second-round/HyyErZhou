package com.example.day13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

public class RecycleGridActivity extends AppCompatActivity {
    private final int mspanCount=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_grid);
        init();
    }

    private void init() {
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,mspanCount);
        gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        GridAdapter gridAdapter=new GridAdapter();


    }
}