package com.example.hyyexam14;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

@SuppressLint("AppCompatCustomView")
public class MyImages extends ImageView {

    public MyImages(Context context) {
        super(context);
    }

    public MyImages(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImages(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
