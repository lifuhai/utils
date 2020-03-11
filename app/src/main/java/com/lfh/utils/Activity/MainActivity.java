package com.lfh.utils.Activity;



import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.lfh.frame.PackageUtil;
import com.lfh.frame.TimeUtils;
import com.lfh.frame.ToastMgr;
import com.lfh.frame.ZhengZe_ID_And_Phone;
import com.lfh.utils.Base.BaseActivity;
import com.lfh.utils.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {



    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        findViewById(R.id.toast).setOnClickListener(this);
        findViewById(R.id.id_card).setOnClickListener(this);
        findViewById(R.id.phone).setOnClickListener(this);
        findViewById(R.id.preview).setOnClickListener(this);
        findViewById(R.id.getPacke).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toast:
                ToastMgr.builder.display("111111111111111111");
                break;
            case R.id.phone:
                ToastMgr.builder.display(ZhengZe_ID_And_Phone.isMobile("15388888888") + "cccccccccccccc");
                break;
            case R.id.id_card:
                String msg = ZhengZe_ID_And_Phone.validate_effective("11292519900905XXXX");

                if (msg.equals("1129251990090XXXX")) {
                    ToastMgr.builder.display(msg + "cccccccccccccccc");
                } else {
                    ToastMgr.builder.display(msg);
                }

                break;

            case R.id.preview:

                startActivity(new Intent(this, TestPreviewActivity.class));
                break;
            case R.id.getPacke:

                Log.d("ccccccccccccc", "onClick: " + PackageUtil.getAppPackageName(this));
                ToastMgr.builder.display(TimeUtils.getNowTime()+"c cccc"+TimeUtils.stampToDate(System.currentTimeMillis()+""));


                break;
        }
    }


}
