package com.example.yezhennan220.myapplication.butterknife;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.yezhennan220.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ButterKnifeActivity extends Activity {

    @BindView(R.id.btk_hello_text1)
    TextView helloText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);

        ButterKnife.bind(this);

        helloText1.setText("I'm Changed by Butter Knife");
    }
}
