package com.bawei.mymvp.mvp2.view;

import android.app.Activity;

/**
 * view层接口，内部两个回调方法
 * 第一个成功，第二个失败
 * @param <T>
 */
public interface IView<T> {
     void success(T data);
     void fail(String msg);
}
