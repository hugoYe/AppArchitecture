package com.example.yezhennan220.myapplication.jsInteration;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import com.example.yezhennan220.myapplication.R;

public class JsInterationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.js_interation);

        Log.i("yezhennan", "JsInterationActivity onCreate");

        MagicWebViewFragment mwf = new MagicWebViewFragment();
//        mwf.setLoadUrl("http://baidu.com");
        mwf.setLoadUrl("file:///android_asset/js_java_interaction.html");
        mwf.setJsInteracion(new JsInteration(), "control");
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.example_hello_container_fl, mwf);
        ft.commit();

        Log.i("yezhennan", "JsInterationActivity onCreate   mwf.getWebView().loadUrl");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("yezhennan", "JsInterationActivity onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("yezhennan", "JsInterationActivity onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("yezhennan", "JsInterationActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("yezhennan", "JsInterationActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("yezhennan", "JsInterationActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("yezhennan", "JsInterationActivity onDestroy");
    }
}
