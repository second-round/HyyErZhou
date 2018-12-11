package com.example.hyyerzhou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hyyerzhou.bean.LoginBean;
import com.example.hyyerzhou.persenter.PersenterImpl;
import com.example.hyyerzhou.view.IView;

public class ZhuActivity extends AppCompatActivity implements View.OnClickListener,IView {
    private EditText editText,editText2;
    private TextView textView2;
    private Button button;
    private PersenterImpl persenter;
    private String path="http://www.zhaoapi.cn/user/reg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        initView();
    }

    private void initView() {
        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        textView2=findViewById(R.id.textView2);
        button=findViewById(R.id.button);
        persenter=new PersenterImpl(this);
        textView2.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //注册
            case R.id.button:
                persenter.sendMessage(path+"?mobile="+editText.getText().toString()+"&password="+editText2.getText().toString(),LoginBean.class);
                break;
            //找回密码
            case R.id.textView2:
                break;
            default:
                break;
        }
    }

    @Override
    public void setData(Object o) {
        LoginBean loginBean= (LoginBean) o;
        Toast.makeText(ZhuActivity.this,loginBean.getMsg(),Toast.LENGTH_LONG).show();
        if (loginBean.getCode()==0){
            finish();
        }
    }
}
