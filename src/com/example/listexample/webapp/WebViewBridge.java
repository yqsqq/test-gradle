package com.example.listexample.webapp;

import android.content.Context;
import android.widget.Toast;

public class WebViewBridge {
  
  Context context = null;
  
  public WebViewBridge(Context context) {
    this.context = context;
  }
  
  public void showMessage(String message) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show();
  }

}
