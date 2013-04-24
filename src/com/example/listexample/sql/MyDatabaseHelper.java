package com.example.listexample.sql;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MyDatabaseHelper {
  
  MySqliteHelper helper = null;
  SQLiteDatabase db = null;
  
  public MyDatabaseHelper(Context context) {
    helper = new MySqliteHelper(context);
    db = helper.getWritableDatabase();
  }
  
  public long insertUser(String name, String phone) {
    ContentValues contentValues = new ContentValues();
    contentValues.put(DBConstants.COLUMN_USER_NAME, name);
    contentValues.put(DBConstants.COLUMN_USER_PHONE, phone);
    
    return db.insert(DBConstants.TABLE_NAME_USERS, null, contentValues);
  }
  
  public int updatetUser(int id, String name, String phone) {
    ContentValues contentValues = new ContentValues();
    contentValues.put(DBConstants.COLUMN_USER_NAME, name);
    contentValues.put(DBConstants.COLUMN_USER_PHONE, phone);
    String whereClause = DBConstants.COLUMN_USER_ID + "=?";
    return db.update(DBConstants.TABLE_NAME_USERS, contentValues, whereClause, new String[]{id+""});
  }
  
  public List<User> selectUsers(String where) {
    List<User> users = new ArrayList<User>();
    try {
      Cursor cursor = db.query(DBConstants.TABLE_NAME_USERS, null, where, null, null, null, null);
      User user = null;
      if (cursor != null){
        if (cursor.moveToFirst()) {
          do {
            user = new User();
            user.setId(cursor.getInt(cursor.getColumnIndex(DBConstants.COLUMN_USER_ID)));
            user.setName(cursor.getString(cursor.getColumnIndex(DBConstants.COLUMN_USER_NAME)));
            user.setPhone(cursor.getString(cursor.getColumnIndex(DBConstants.COLUMN_USER_PHONE)));
          } while(cursor.moveToNext());
        }
      }
    } catch (Exception e) {
    }
    return users;
  }
  
  public void close() {
    db.close();
  }

}
