package com.example.yezhennan220.myapplication.jsInteration;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Class description
 * 封装了Webview的Fragment，利用Webview来显示页面
 *
 * @author YEZHENNAN220
 * @date 2016-06-22 17:00
 */
public class MagicWebViewFragment extends Fragment {

    private static final String LOG_TAG = MagicWebViewFragment.class.getSimpleName();

    private WebView mWebView;
    private boolean mIsWebViewAvailable;
    private String mLoadUrl;
    private Object mJsObject;
    private String mJsApiName;

    public void setLoadUrl(String loadUrl) {
        this.mLoadUrl = loadUrl;
    }

    public void setJsInteracion(Object jsObject, String apiName) {
        this.mJsObject = jsObject;
        this.mJsApiName = apiName;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i("yezhennan", "MagicWebViewFragment onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("yezhennan", "MagicWebViewFragment onCreate");
    }

    @SuppressLint("JavascriptInterface")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("yezhennan", "MagicWebViewFragment onCreateView");

        if (mWebView != null) {
            mWebView.destroy();
        }
        try {
            mWebView = new WebView(getActivity());
        } catch (Exception e) {
            mWebView = new WebView(getActivity());
        }
        mIsWebViewAvailable = true;

        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebView.loadUrl(mLoadUrl);

        if (mJsObject != null && mJsApiName != null) {
            mWebView.addJavascriptInterface(mJsObject, mJsApiName);
        } else {
            Log.e(LOG_TAG, "JavascriptInterface object is null !");
        }

//        // test begin
//        mWebView.addJavascriptInterface(new com.example.yezhennan220.myapplication.jsInteration.JsInteration(), "control");
//        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                testMethod(mWebView);
            }

        });
//        // test end

        return mWebView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("yezhennan", "MagicWebViewFragment onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("yezhennan", "MagicWebViewFragment onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("yezhennan", "MagicWebViewFragment onStart");
        if (mWebView != null)
            mWebView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("yezhennan", "MagicWebViewFragment onPause");
        if (mWebView != null)
            mWebView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("yezhennan", "MagicWebViewFragment onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("yezhennan", "MagicWebViewFragment onDestroyView");
        mIsWebViewAvailable = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("yezhennan", "MagicWebViewFragment onDestroy");
        if (mWebView != null) {
            mWebView.destroy();
            mWebView = null;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("yezhennan", "MagicWebViewFragment onDetach");
    }

    /**
     * Gets the WebView.
     */
    public WebView getWebView() {
        return mIsWebViewAvailable ? mWebView : null;
    }


    // test begin
    public class JsInteration {

        @JavascriptInterface
        public void toastMessage(String message) {
            Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
        }

        @JavascriptInterface
        public void onSumResult(int result) {
            Log.i("yezhennan", "onSumResult result=" + result);
        }
    }

    private void testMethod(WebView webView) {
//        String call = "javascript:sayHello()";

//        String call = "javascript:alertMessage(\"" + "content" + "\")";
//
//        String call = "javascript:toastMessage(\"" + "content" + "\")";
//
        String call = "javascript:sumToJava(1,2)";
        webView.loadUrl(call);

    }
    // test end

    public interface Callback {
    }
}
