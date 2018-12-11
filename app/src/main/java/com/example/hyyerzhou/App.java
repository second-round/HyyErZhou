package com.example.hyyerzhou;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        UMConfigure.init(this,"5a12384aa40fa3551f0001d1"
//                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
        UMConfigure.init(this,"5a12384aa40fa3551f0001d1","umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        CrashReport.initCrashReport(getApplicationContext(), "3c39e78d25", false);
        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(this)
                .diskCacheSize(20*1024*1024)
                .memoryCacheSizePercentage(10)
                .defaultDisplayImageOptions(new DisplayImageOptions.Builder()
                        .cacheOnDisk(true)
                        .cacheInMemory(true)
                        .build())
                .build()

        );

    }
}
