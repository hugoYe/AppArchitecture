package com.example.yezhennan220.myapplication.leakcanary;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.yezhennan220.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeakCanaryActivity extends Activity {

    @BindView(R.id.leak_demo_text)
    TextView leakText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_canary);

        ButterKnife.bind(this);

        // 退出后，由于持有activity的context导致内存泄露
//        LeakHelper.getInstance(this).setRetainedTextView(leakText);

        // 退出后，由于TextView持有了application的context仍然导致内存泄露
        LeakHelper.getInstance(this.getApplicationContext()).setRetainedTextView(leakText);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 解决内存泄露方案,但是不建议这样做，正确姿势应该是在Helper类中将TextView的交互callback回activity自身
//        LeakHelper.getInstance(this.getApplicationContext()).removeTextView();
    }
}
