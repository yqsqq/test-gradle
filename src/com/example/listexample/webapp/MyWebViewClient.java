package com.example.listexample.webapp;

import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {
  
  private final static String TAG = "MyWebViewClient";
  
  @Override
  public boolean shouldOverrideUrlLoading(WebView view, String url) {
    Log.e(TAG, "URL: "+ url);
    return super.shouldOverrideUrlLoading(view, url);
  }

}
