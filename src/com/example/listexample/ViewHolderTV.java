package com.example.listexample;

import android.widget.TextView;

public class ViewHolderTV extends ViewHolder {
  private TextView textView = null;
  
  public TextView getTextView() {
    return textView;
  }

  public void setTextView(TextView textView) {
    this.textView = textView;
  }
}
