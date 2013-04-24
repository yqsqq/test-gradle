package com.example.listexample.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySqliteHelper extends SQLiteOpenHelper {
  
  private static final String TAG = "MySqliteHelper";

  public MySqliteHelper(Context context) {
    super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    Log.e(TAG, "onCreate");
    db.execSQL(DBConstants.TABLE_USERS_DDL);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Log.e(TAG, "onUpgrade oldVer: "+ oldVersion + " newVer: " + newVersion);
//    db.execSQL(DBConstants.ALTER_TABLE_USERS_DDL);
  }

}
