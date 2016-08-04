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

import com.basecore.library.logger.LogUtil;
import com.example.yezhennan220.myapplication.R;
import com.example.yezhennan220.myapplication.annotation.UseCaseTracker;
import com.example.yezhennan220.myapplication.butterknife.ButterKnifeActivity;
import com.example.yezhennan220.myapplication.jsInteration.JsInterationActivity;

public class BaseActivity extends Activity implements View.OnClickListener {

    private static final int SAMPLE_JSINTERATION = 0;
    private static final int SAMPLE_ANNOTATION = 1;
    private static final int SAMPLE_BUTTER_KNIFE = 2;
    private static final int SAMPLE_LOGGER = 3;

    private static String sSampleList[] = {"JsInteration Sample", "Annotation Sample", "Butter Knife Sample", "Logger Sample"};

    private static boolean loggerFormatter;

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
            case SAMPLE_JSINTERATION:
                startActivity(new Intent(this, JsInterationActivity.class));
                break;
            case SAMPLE_ANNOTATION:
                UseCaseTracker.trackTest();
                break;
            case SAMPLE_BUTTER_KNIFE:
                startActivity(new Intent(this, ButterKnifeActivity.class));
                break;
            case SAMPLE_LOGGER:
                LogUtil.setLogger(true);
                loggerFormatter = !loggerFormatter;
                LogUtil.setLoggerFormat(loggerFormatter);

                LogUtil.i("yezhennan", "Log i sample !");
                LogUtil.d("yezhennan1", "Log d sample !");
                LogUtil.w("yezhennan2", "Log w sample !");
                LogUtil.v("yezhennan3", "Log v sample !");
                LogUtil.wtf("yezhennan4", "Log wtf sample !");
                LogUtil.e("yezhennan5", "Log e sample !");
                LogUtil.json("{\n" +
                        "\"code\": 0,\n" +
                        "\"msg\": \"success\",\n" +
                        "\"data\": {\n" +
                        "\"sToken\": \"5db09c3d69e358abeb975cf38b46f589\",\n" +
                        "\"sLogoutUrl\": \"http://crm.jiangqiuling.dev2.anhouse.com.cn/ydyx/service/auth/logout\",\n" +
                        "\"menuList\": [\n" +
                        "{\n" +
                        "\"name\": \"销售管理\",\n" +
                        "\"child\": [\n" +
                        "{\n" +
                        "\"name\": \"查看客户信息\",\n" +
                        "\"url\": \"http://crm.jiangqiuling.dev2.anhouse.com.cn/ydyx/customer/query\",\n" +
                        "\"type\": \"h5\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"name\": \"查看交易信息\",\n" +
                        "\"url\": \"http://crm.jiangqiuling.dev2.anhouse.com.cn/ydyx/trade/query\",\n" +
                        "\"type\": \"h5\"\n" +
                        "}\n" +
                        "]\n" +
                        "},\n" +
                        "{\n" +
                        "\"name\": \"客户管理\",\n" +
                        "\"child\": [\n" +
                        "{\n" +
                        "\"name\": \"登记客户信息\",\n" +
                        "\"url\": \"window.WebViewJavascriptBridge.callHandler('ydyxAndroidScan', {\\\"type\\\":1,\\\"submitUrl\\\":\\\"http:\\\\/\\\\/crm.jiangqiuling.dev2.anhouse.com.cn\\\\/ydyx\\\\/user\\\\/login\\\",\\\"asyncUrl\\\":\\\"\\\"}, function(responseData) {\\r\\n                        //document.getElementById(\\\"show\\\").innerHTML = \\\"send get responseData from java, data = \\\" + responseData;\\r\\n       })\",\n" +
                        "\"type\": \"js\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"name\": \"当前客户详情\",\n" +
                        "\"url\": \"http://crm.jiangqiuling.dev2.anhouse.com.cn/ydyx/user/detail/%7BuserID%7D\",\n" +
                        "\"type\": \"h5\"\n" +
                        "}\n" +
                        "]\n" +
                        "},\n" +
                        "{\n" +
                        "\"name\": \"产品管理\",\n" +
                        "\"child\": [\n" +
                        "{\n" +
                        "\"name\": \"好房宝\",\n" +
                        "\"url\": \"http://hfb.jiangqiuling.dev2.anhouse.com.cn/info/my.htm\",\n" +
                        "\"type\": \"h5\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"name\": \"好房贷\",\n" +
                        "\"url\": \"\",\n" +
                        "\"type\": \"h5\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"name\": \"安安租\",\n" +
                        "\"url\": \"\",\n" +
                        "\"type\": \"h5\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"name\": \"二手房\",\n" +
                        "\"url\": \"\",\n" +
                        "\"type\": \"h5\"\n" +
                        "}\n" +
                        "]\n" +
                        "}\n" +
                        "]\n" +
                        "}\n" +
                        "}");
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
