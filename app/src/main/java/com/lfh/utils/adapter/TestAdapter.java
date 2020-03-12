package com.lfh.utils.adapter;

import android.content.Context;

import com.lfh.frame.ListAdapter.Baseadapter;
import com.lfh.frame.ListAdapter.ViewHolder;
import com.lfh.utils.R;

import java.util.List;

public class TestAdapter extends Baseadapter<String> {
    public TestAdapter(List<String> list, Context context, int layout_id) {
        super(list, context, layout_id);
    }

    @Override
    public void convert(ViewHolder holder, String s,int p) {
        holder.setText(R.id.tv_lv,s);
    }
}
