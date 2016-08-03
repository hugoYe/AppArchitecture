package com.example.yezhennan220.myapplication.jsInteration;

import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * Class description
 *
 * @author YEZHENNAN220
 * @date 2016-06-23 15:54
 */
public class JsInteration {
    @JavascriptInterface
    public void toastMessage(String message) {
        Log.i("yezhennan", "toastMessage = " + message);
    }

    @JavascriptInterface
    public void onSumResult(int result) {
        Log.i("yezhennan", "onSumResult result=" + result);
    }
}
