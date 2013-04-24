package com.example.listexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class NavigationAActivity extends Activity implements OnClickListener {
  
  private final static String TAG = "Activity_A";
  private Button myButton = null;
  private static int REQUEST_ID_ACTIVITYB = 0;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.e(TAG, "onCreate");
    
    setContentView(R.layout.activity_a);
    myButton = (Button) findViewById(R.id.btnGoToB);
    myButton.setOnClickListener(this);
  }
  
  @Override
  public void onClick(View view) {
    if (view.getId() == R.id.btnGoToB) {
      Log.e(TAG, "click on goto B");
      Intent intent = new Intent(this, NavigationBActivity.class);
      intent.putExtra(NavigationBActivity.DATA_INPUT_COMPANY_NAME, "Crowd Interactive");
      startActivityForResult(intent, REQUEST_ID_ACTIVITYB);
    }
  }
  
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_ID_ACTIVITYB) {
      if (resultCode == RESULT_OK) {
        String userName = data.getExtras().getString(NavigationBActivity.DATA_USER_NAME);
        Toast.makeText(this, "Selected User: " + userName, Toast.LENGTH_LONG).show();
      }
    }
  }
  
  @Override
  protected void onRestart() {
    super.onRestart();
    Log.e(TAG, "onRestart");
  }
  
  @Override
  protected void onStart() {
    super.onStart();
    Log.e(TAG, "onStart");
  }
  
  @Override
  protected void onResume() {
    super.onResume();
    Log.e(TAG, "onResume");
  }
  
  @Override
  protected void onPause() {
    super.onPause();
    Log.e(TAG, "onPause");
  }
  
  @Override
  protected void onStop() {
    super.onStop();
    Log.e(TAG, "onStop");
  }
  
  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.e(TAG, "onDestroy");
  }

}
