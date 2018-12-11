package com.bawei.mymvp.mvp2.presemter;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.bawei.mymvp.mvp2.NetUtils;
import com.bawei.mymvp.mvp2.User;
import com.bawei.mymvp.mvp2.view.IView;

public class LoginPresenter {
    /**
     *  持有view的实例
     */
    private IView mIView;

    public LoginPresenter(@NonNull IView iView) {
        mIView = iView;
    }

    public void submit(User user){
        if(checkName(user.getName()) && checkPw(user.getPw())){
            //进行网络请求
            boolean loginResult = NetUtils.loginApi(user);
            //拿到结果后
            if (loginResult){
                //通过view的实例，把数据回调给view
                mIView.success("");
            }else{
                //通过view的实例，把数据回调给view
                mIView.fail("失败");
            }
        }else{
            //通过view的实例，把数据回调给view
            mIView.fail("用户名密码错");
        }
    }


    public void detachView(){
        mIView = null;
    }



    private boolean checkName(String name){
        return !TextUtils.isEmpty(name);
    }

    private boolean checkPw(String pw){
        return (!TextUtils.isEmpty(pw) && pw.length()>=6);
    }
}
