package com.example.listexample.webapp;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.listexample.R;
import com.example.listexample.utils.HttpUtils;

public class MyWebAppActivity extends Activity {
  
  private WebView webView = null;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_webapp);
    
    webView = (WebView) findViewById(R.id.wvBrowser);
    initBrowser();
  }
  
  protected void initBrowser() {
    WebSettings webSettings = webView.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webView.addJavascriptInterface(new WebViewBridge(this), "AndroidInterface");
    webView.setWebViewClient(new MyWebViewClient());
    webView.loadData(getHtml(), "text/html", "utf-8");
  }
  
  protected String getHtml() {
    InputStream is = null;
    String html = "";
    
    try {
      is = getAssets().open("htdocs/index.html");
      html = HttpUtils.convertStreamtoString(is);
      return html;
    } catch (IOException e) {
      html = "";
      e.printStackTrace();
    } finally {
      if (is != null) {
        try {
          is.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }
  
  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
      if (webView.canGoBack()) {
        webView.goBack();
        return true;
      }
    }
    return super.onKeyDown(keyCode, event);
  }

}
