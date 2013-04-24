package com.example.listexample.utils;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;

import com.example.listexample.MyAdapter;

public class GetTweetsTask extends AsyncTask<String, Integer, List<Tweet>> {
  
  private MyAdapter myAdapter = null;
  
  public void setAdapter(MyAdapter myAdapter) {
    this.myAdapter = myAdapter;
  }

  @Override
  protected List<Tweet> doInBackground(String... params) {
    List<Tweet> tweets = null;
    
    if (params != null && params.length > 0) {
      try {
        String url = params[0];
        String jsonString = HttpUtils.connect(url, null);
        tweets = JsonParser.parseTwitterTimeline(jsonString);
      } catch(Exception e) {
        e.printStackTrace();
        tweets = new ArrayList<Tweet>();
      }
    } else {
      tweets = new ArrayList<Tweet>();
    }
    
    return tweets;
  }

  @Override
  protected void onPostExecute(List<Tweet> result) {
    myAdapter.addElements(result);
  }
  
}
