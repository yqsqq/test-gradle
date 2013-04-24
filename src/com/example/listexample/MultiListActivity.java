package com.example.listexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.listexample.utils.HttpUtils;

public class MultiListActivity extends Activity {
  
  private ListView myList = null;
  private MyAdapter myAdapter = null;
  
  public enum RowType {
    ROW1,
    ROW2,
    ROW3
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_multi);
    
    Log.e("TAG", "a: " + HttpUtils.connect("http://www.google.com", null));
    
    myList = (ListView) findViewById(R.id.list_view_lista);
    myAdapter = new MyAdapter(this);
    myList.setAdapter(myAdapter);
    
    //adding elements
    int j = 1;
    for (int i = 0; i <= 15; i++) {
      j++;
      switch (j) {
        case 1:
          myAdapter.addElement("Juan: " + i, RowType.ROW1);
          break;
        case 2:
          myAdapter.addElement("Juan: " + i, RowType.ROW2);
          break;
        case 3:
          myAdapter.addElement("Juan: " + i, RowType.ROW3);
          break;
        default:
          break;
      }
      if (i == 3) {
        j = 1;
      }
    }
  }

}
