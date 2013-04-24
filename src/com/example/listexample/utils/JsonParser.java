package com.example.listexample.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParser {
  
  public static List<Tweet> parseTwitterTimeline(String jsonString) {
    List<Tweet> tweets = new ArrayList<Tweet>();
    
    try {
      Tweet tweet = null;
      JSONArray jsonArray = new JSONArray(jsonString);
      JSONObject jsonObject = null;
      JSONObject jsonUserObject = null;
      for (int a = 0; a < jsonArray.length(); a++) {
        tweet = new Tweet();
        tweets.add(tweet);
        
        jsonObject = jsonArray.getJSONObject(a);
        jsonUserObject = jsonObject.getJSONObject("user");
        
        tweet.setUserImage(jsonUserObject.optString("profile_image_url"));
        tweet.setUserName(jsonUserObject.optString("name"));
        tweet.setTweet(jsonObject.optString("text"));
        tweet.setUrl(jsonObject.optString("created_at"));
        tweet.setId(jsonObject.optString("id_str"));
      }
    } catch (Exception e) {
      
    }
    return tweets;
  }

}
