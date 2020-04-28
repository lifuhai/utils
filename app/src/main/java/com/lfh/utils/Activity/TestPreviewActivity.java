package com.lfh.utils.Activity;


import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.lfh.utils.Base.BaseActivity;
import com.lfh.utils.R;
import com.lfh.utils.adapter.TestAdapter;

import java.util.ArrayList;
import java.util.List;

public class TestPreviewActivity extends BaseActivity {

    private static final String TAG = "TestPreviewActivity";
    private ListView listView;
    private TestAdapter adapter;


    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_test_preview);
        Log.d(TAG, "initView: 11111111111111111111111");
        hold(R.id.linear);//绑定view
        listView = findViewById(R.id.lv_list);
        mVaryViewHelper.showLoadingView();//预加载
        List<String>list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("呵呵"+i);
        }
        adapter = new TestAdapter(list,this,R.layout.item_list);
        listView.setAdapter(adapter);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    CommonUtils.runOnUIThread(new Runnable() {
                        @Override
                        public void run() {
                            mVaryViewHelper.showErrorView(R.drawable.bg_btn);
//                            mVaryViewHelper.showEmptyView("11111");
//                            mVaryViewHelper.showEmptyView("123",getResources().getDrawable(R.mipmap.ic_launcher));
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    boolean flag;
    @Override
    public void initData() {
        super.initData();
        Log.d(TAG, "initView: 2222222222222222222222222222");
        if (flag) {
            mVaryViewHelper.showDataView();
        }
        flag =true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        listView = null;
    }
}
