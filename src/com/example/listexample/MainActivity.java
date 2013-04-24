package com.example.listexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.listexample.utils.GetTweetsTask;

public class MainActivity extends Activity {

  private final static String myTag = "MainActivity";
  private ListView myList = null;
  private MyAdapter myAdapter = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    myList = (ListView) findViewById(R.id.list_view_lista);
    myAdapter = new MyAdapter(this);
    myList.setAdapter(myAdapter);

    // adding elements
    GetTweetsTask task = new GetTweetsTask();
    task.setAdapter(myAdapter);
    task.execute("http://www.recursosdelweb.com/feed_twitter.json");

    // myAdapter.addElements(tweets);
  }

}
