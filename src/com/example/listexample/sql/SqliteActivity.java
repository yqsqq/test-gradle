package com.example.listexample.sql;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.listexample.R;

public class SqliteActivity extends Activity {
  
  private static final String TAG = "SqliteActicity";
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sqlite);
    
    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);
    dbHelper.insertUser("John", "123456");
    dbHelper.insertUser("Sarah", "480455");
    dbHelper.insertUser("Michael", "568888");
    dbHelper.insertUser("Michelle", "564484");
    
    List<User> users = dbHelper.selectUsers(DBConstants.COLUMN_USER_NAME + "='John'");
    for (User user : users) {
      Log.e(TAG, "user id: " + user.getId());
      Log.e(TAG, "user id: " + user.getName());
      Log.e(TAG, "user id: " + user.getPhone());
      Log.e(TAG, "----------------");
    }
  }
  
}
