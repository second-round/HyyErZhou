package com.example.hyyerzhou;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class MView extends TextView {
    public MView(Context context) {
        super(context);
    }

    public MView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}
