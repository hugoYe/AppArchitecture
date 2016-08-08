package com.example.yezhennan220.myapplication.leakcanary;

import android.content.Context;
import android.widget.TextView;

/**
 * Class description
 *
 * @author YEZHENNAN220
 * @date 2016-08-08 11:39
 */
public class LeakHelper {

    private static LeakHelper ourInstance = null;

    private Context mCtx;
    private TextView mTextView;

    public static LeakHelper getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new LeakHelper(context);
        }
        return ourInstance;
    }

    private LeakHelper() {
    }

    private LeakHelper(Context context) {
        this.mCtx = context;
    }


    public void setRetainedTextView(TextView tv) {
        this.mTextView = tv;
        mTextView.setText(mCtx.getString(android.R.string.ok));
    }

    public void removeTextView() {
        this.mTextView = null;
    }
}
