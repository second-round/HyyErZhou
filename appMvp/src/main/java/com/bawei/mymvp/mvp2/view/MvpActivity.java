package com.bawei.mymvp.mvp2.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.mymvp.R;
import com.bawei.mymvp.mvp2.presemter.LoginPresenter;
import com.bawei.mymvp.mvp2.User;

public class MvpActivity extends Activity implements View.OnClickListener, IView {
    EditText mEtName, mEtPw;
    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        initView();

        //创建一个Presenter实例
        initPresenter();
    }

    /**
     * 绑定Presenter
     */
    private void initPresenter() {
        //把view传给presenter进行绑定
        mLoginPresenter = new LoginPresenter(this);
    }

    private void initView() {
        mEtName = findViewById(R.id.et_name);
        mEtPw = findViewById(R.id.et_pw);

        mEtPw.invalidate();
        findViewById(R.id.button_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.button_login:
                User user = new User(mEtName.getText().toString(), mEtPw.getText().toString());
                //通过presenter的实例，调用presenter中的方法
                mLoginPresenter.submit(user);
                break;
            default:
                break;
        }
    }

    /**
     * 在Activity結束的時候解綁Presenter
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.detachView();
    }

    @Override
    public void success(Object data) {
        //接受到了结果，进行数据展示
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fail(String msg) {
        //接受到了结果，进行数据展示
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
