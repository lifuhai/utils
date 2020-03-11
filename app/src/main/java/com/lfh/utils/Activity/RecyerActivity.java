package com.lfh.utils.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lfh.frame.ImageUtils;
import com.lfh.frame.RecyerAdapter.BaseRecyerAdapter;
import com.lfh.frame.RecyerAdapter.LinearItemDecoration;
import com.lfh.frame.ToastMgr;
import com.lfh.utils.Base.BaseActivity;
import com.lfh.utils.R;
import com.lfh.utils.adapter.RecyerAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyerActivity extends BaseActivity {


    private RecyclerView recyclerView;

    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_recyer);
        recyclerView = findViewById(R.id.recycer);
        List<String>list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("测试"+i);
        }




        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearItemDecoration linearItemDecoration = new LinearItemDecoration();
        linearItemDecoration.setColor(Color.RED);
        linearItemDecoration.setSpanSpace(ImageUtils.px2dp(10,this));



        recyclerView.addItemDecoration(linearItemDecoration);



        RecyerAdapter adapter = new RecyerAdapter(this,list,R.layout.item_list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseRecyerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                ToastMgr.builder.display("ccccccccccccc"+position);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                ToastMgr.builder.display("ccccccccccc长摁"+position);
                return true;
            }
        });

    }


}
