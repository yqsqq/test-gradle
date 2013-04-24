package com.example.listexample.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;

public class HttpUtils {
  
  private static List<NameValuePair> hashtableToListNameValuePair(Hashtable<String, String> postParameters) {
    List<NameValuePair> postList = new ArrayList<NameValuePair>();
    for (Entry<String, String> entry : postParameters.entrySet()) {
      postList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
    }
    return postList;
  }
  
  public static String convertStreamtoString(InputStream is) {
    StringBuilder sb = new StringBuilder();
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
      String line = null;
      while ((line = reader.readLine()) != null) {
        sb.append(line + "\n");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return sb.toString();
  }
  
  public static String connect(String url, Hashtable<String, String> postParameters) {
    HttpClient httpClient = null;
    HttpGet httpGet = null;
    HttpPost httpPost = null;
    HttpResponse httpResponse = null;
    String responseString = null;;
    
    try {
      //create Client
      httpClient = new DefaultHttpClient();
      
      if (postParameters != null) {
        //send POST
        httpPost = new HttpPost(url);
        List<NameValuePair> postList = hashtableToListNameValuePair(postParameters);
        httpPost.setEntity(new UrlEncodedFormEntity(postList, "UTF-8"));
        httpResponse = httpClient.execute(httpPost);
      } else {
        // send GET
        httpGet = new HttpGet(url);
        Log.e("asd", "sending get: " + url);
        httpResponse = httpClient.execute(httpGet);
      }
      Log.e("asd", "before convertStream ");
      responseString = convertStreamtoString(httpResponse.getEntity().getContent());
    } catch (Exception e) {
      e.printStackTrace();
      responseString = "";
    }
    return responseString;
  }

}
