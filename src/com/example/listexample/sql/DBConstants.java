package com.example.listexample.sql;

public class DBConstants {

  public static final String DATABASE_NAME = "enterprise_users";
  public static final int DATABASE_VERSION = 1;

  public static final String TABLE_NAME_USERS = "users";
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_USER_ID = "user_id";
  public static final String COLUMN_USER_NAME = "user_name";
  public static final String COLUMN_USER_PHONE = "user_phone";

  public static final String TABLE_USERS_DDL = "CREATE TABLE " + TABLE_NAME_USERS + "("
      + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
      + COLUMN_USER_NAME + " TEXT, "
      + COLUMN_USER_PHONE + " TEXT"
      + ");";

}
