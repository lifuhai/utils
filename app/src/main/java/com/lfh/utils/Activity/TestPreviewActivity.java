package com.lfh.utils.Activity;


import android.os.Bundle;
import android.widget.ListView;

import com.lfh.frame.ListAdapter.Baseadapter;
import com.lfh.frame.ListAdapter.ViewHolder;
import com.lfh.utils.Base.BaseActivity;
import com.lfh.utils.R;

import java.util.ArrayList;
import java.util.List;

public class TestPreviewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_preview);
        hold(R.id.linear);//绑定view
        mVaryViewHelper.showLoadingView();//预加载

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);

                    CommonUtils.runOnUIThread(new Runnable() {
                        @Override
                        public void run() {
//                            mVaryViewHelper.showDataView();
                            mVaryViewHelper.showErrorView();

//                            mVaryViewHelper.showEmptyView("11111");
//                            mVaryViewHelper.showEmptyView("123",getResources().getDrawable(R.mipmap.ic_launcher));
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();



      ListView listView =  findViewById(R.id.lv_list);

        List<String>list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("呵呵"+i);
        }

        listView.setAdapter(new Baseadapter<String>(list,this,R.layout.item_list) {
            @Override
            public void convert(ViewHolder holder, String s) {
                holder.setText(R.id.tv_lv,s);
            }
        });
    }
}
