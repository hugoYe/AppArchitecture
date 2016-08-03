package com.example.yezhennan220.myapplication.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yezhennan220.myapplication.R;
import com.example.yezhennan220.myapplication.annotation.UseCaseTracker;
import com.example.yezhennan220.myapplication.butterknife.ButterKnifeActivity;
import com.example.yezhennan220.myapplication.jsInteration.JsInterationActivity;

public class BaseActivity extends Activity implements View.OnClickListener {

    private static String sSampleList[] = {"JsInteration Sample", "Annotation Sample", "Butter Knife Sample"};

    private ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        mList = (ListView) findViewById(R.id.example_list);

        mList.setAdapter(new MyListAdapter(sSampleList));
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    @Override
    public void onClick(View view) {

        int index = (int) view.getTag();

        switch (index) {
            case 0:
                startActivity(new Intent(this, JsInterationActivity.class));
                break;
            case 1:
                UseCaseTracker.trackTest();
                break;
            case 2:
                startActivity(new Intent(this, ButterKnifeActivity.class));
                break;
        }
    }

    class MyListAdapter extends BaseAdapter {

        private String[] mList;

        public MyListAdapter(String[] list) {
            this.mList = list;
        }

        @Override
        public int getCount() {
            return mList.length;
        }

        @Override
        public Object getItem(int i) {
            return mList[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = new TextView(BaseActivity.this);
                ((TextView) view).setText(mList[i]);
                ((TextView) view).setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dip2px(BaseActivity.this, 50)));
                ((TextView) view).setGravity(Gravity.CENTER_VERTICAL);
                ((TextView) view).setOnClickListener(BaseActivity.this);
                ((TextView) view).setTag(i);
            } else {
                ((TextView) view).setText(mList[i]);
                ((TextView) view).setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dip2px(BaseActivity.this, 50)));
                ((TextView) view).setGravity(Gravity.CENTER_VERTICAL);
                ((TextView) view).setOnClickListener(BaseActivity.this);
                ((TextView) view).setTag(i);
            }
            return view;
        }
    }
}
