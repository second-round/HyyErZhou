package com.bawei.mymvp.mvp2;

import android.os.SystemClock;

public class NetUtils {
    public static boolean loginApi(User user){
        SystemClock.sleep(2000);
        if(user.getName().equals("dj") && user.getPw().equals("123456")){
            //TODO:这里最终需用真正的接口
            return true;
        }
        return false;
    }
}
