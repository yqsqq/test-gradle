package com.example.listexample;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class GpsActivity extends Activity implements OnClickListener, LocationListener {
  
  private final static String TAG = "GPS ACTIVITY";
  private Button btnTurnOn = null;
  private Button btnTurnOff = null;
  private boolean wasOn = false;
  private LocationManager locationManager = null;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_gps);
    
    locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
    
    btnTurnOn = (Button) findViewById(R.id.btnTurnOn);
    btnTurnOff = (Button) findViewById(R.id.btnTurnOff);
    
    btnTurnOn.setOnClickListener(this);
    btnTurnOff.setOnClickListener(this);
  }
  
  @Override
  protected void onRestart() {
    super.onRestart();
    
    if (wasOn) {
      turnOn();
    }
  }
  
  @Override
  protected void onDestroy() {
    locationManager = null;
    super.onDestroy();
  }
  
  @Override
  protected void onStop() {
    turnOff();
    super.onStop();
  }

  @Override
  public void onClick(View v) {
    if (v.getId() == R.id.btnTurnOn) {
      Log.e(TAG, "onClick On");
      turnOn();
    } else if (v.getId() == R.id.btnTurnOff) {
      Log.e(TAG, "onClick Off");
      turnOff();
    }
  }

  @Override
  public void onLocationChanged(Location location) {
    Log.e(TAG, "onLocationChanged");
    String locationString = location.getLatitude() + ", " + location.getLongitude(); 
    Toast.makeText(this, "New Location: " + locationString, Toast.LENGTH_LONG).show();
  }
  
  protected void turnOn() {
    if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
      locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER, 5000 , 1, this);
    } else if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
      locationManager.requestLocationUpdates(
          LocationManager.NETWORK_PROVIDER, 5000 , 1, this);
    } else {
      Location lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
      if (lastLocation == null) {
        lastLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
      }
      
      if (lastLocation != null) {
        String lastLocationString = lastLocation.getLatitude() + ", " + lastLocation.getLongitude();
        Toast.makeText(this, "Last Known Location: " + lastLocationString, Toast.LENGTH_LONG).show(); 
      }
    }
    
    wasOn = true;
  }
  
  protected void turnOff() {
    locationManager.removeUpdates(this);
  }

  @Override
  public void onProviderDisabled(String provider) {
    Log.e(TAG, "onProviderDisabled");
    turnOff();
    turnOn();
  }

  @Override
  public void onProviderEnabled(String provider) {
    Log.e(TAG, "onProviderEnabled");
    turnOff();
    turnOn();
  }

  @Override
  public void onStatusChanged(String provider, int status, Bundle extras) {
    Log.e(TAG, "onStatusChanged");
  }

}
