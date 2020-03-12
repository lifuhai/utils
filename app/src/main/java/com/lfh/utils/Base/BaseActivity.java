package com.lfh.utils.Base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;


import com.lfh.frame.AppManager;
import com.lfh.frame.preview.VaryViewHelper;
import com.lfh.utils.R;

public abstract class BaseActivity extends AppCompatActivity {
    public VaryViewHelper mVaryViewHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        initView(savedInstanceState);
        initData();

    }

    public abstract void initView(Bundle savedInstanceState);


    /**
     * 加载数据
     * 可实现 可不实现
     */
    public void initData() {

    }

    public void hold(int id) {

        mVaryViewHelper = new VaryViewHelper.Builder()
                .setDataView(findViewById(id))//放数据的父布局，逻辑处理在该Activity中处理
                .setLoadingView(LayoutInflater.from(this).inflate(R.layout.layout_loadingview, null))//加载页，无实际逻辑处理
                .setEmptyView(LayoutInflater.from(this).inflate(R.layout.layout_emptyview, null))//空页面，无实际逻辑处理
                .setErrorView(LayoutInflater.from(this).inflate(R.layout.layout_errorview, null))//错误页面
                .build();
        mVaryViewHelper.mErrorView.findViewById(R.id.vv_error_refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });
    }

    ;


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mVaryViewHelper != null) {
            mVaryViewHelper.releaseVaryView();
        }
        AppManager.finishActivity();

    }

}
