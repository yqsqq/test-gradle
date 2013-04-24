package com.example.listexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class NavigationBActivity extends Activity implements OnClickListener {
  
  private final static String TAG = "Activity_B";
  private Button myButton = null;
  public final static String DATA_USER_NAME = "DATA_USER_NAME";
  public final static String DATA_INPUT_COMPANY_NAME = "COMPANY";
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.e(TAG, "onCreate");
    
    String companyName = getIntent().getExtras().getString(DATA_INPUT_COMPANY_NAME);
    Toast.makeText(this, "Company: " + companyName, Toast.LENGTH_LONG).show();
    
    setContentView(R.layout.activity_b);
    myButton = (Button) findViewById(R.id.btnGoToA);
    myButton.setOnClickListener(this);
  }
  
  @Override
  public void onClick(View view) {
    if (view.getId() == R.id.btnGoToA) {
      Log.e(TAG, "click on goto A");
      Intent data = new Intent();
      data.putExtra(DATA_USER_NAME, "Manolo");
      setResult(RESULT_OK, data);
      finish();
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
