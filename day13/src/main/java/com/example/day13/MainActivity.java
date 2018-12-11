package com.example.day13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.recycleLinearActivity).setOnClickListener(this);
        findViewById(R.id.recycleGridActivity).setOnClickListener(this);
        findViewById(R.id.recycleStaggeredActivity).setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.recycleLinearActivity:
                //还差自定义分割线----完成
                intent.setClass(this,RecycleLinearActivity.class);
                break;
            case R.id.recycleGridActivity:

                intent.setClass(this,RecycleGridActivity.class);
                break;
            case R.id.recycleStaggeredActivity:
                intent.setClass(this,RecycleStaggeredActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
