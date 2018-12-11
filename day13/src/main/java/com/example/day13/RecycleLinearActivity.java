package com.example.day13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.example.day13.adapter.LinearAdapter;
import com.example.day13.bean.User;

public class RecycleLinearActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_linear);
        initView();
    }

    private void initView() {
        recyclerView=findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        LinearAdapter linearAdapter=new LinearAdapter();
        for (int i=0;i<10;i++){
            User user=new User();
            user.setName("张"+i);
            linearAdapter.setList(user);
        }

        recyclerView.setAdapter(linearAdapter);
        DividerItemDecoration divider=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);


    }
}