package com.lfh.utils;

import android.app.Application;
import android.os.Handler;

import com.lfh.frame.ImageUtils;
import com.lfh.frame.ToastMgr;

public class App extends Application {
    public static Handler mHandler;
    @Override
    public void onCreate() {
        super.onCreate();
        ToastMgr.builder.init(this);
        mHandler = new Handler();
        ImageUtils.initWindow(this);
    }
}
