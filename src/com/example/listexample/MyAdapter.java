package com.example.listexample;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.listexample.MultiListActivity.RowType;
import com.example.listexample.utils.Tweet;

public class MyAdapter extends BaseAdapter {

  private final static String myTag = "MainActivity";
  MainActivity parentActivity;
  List<Tweet> data = new ArrayList<Tweet>();
  private List<Integer> arrayPositionsRow1 = new ArrayList<Integer>();
  private List<Integer> arrayPositionsRow2 = new ArrayList<Integer>();
  private List<Integer> arrayPositionsRow3 = new ArrayList<Integer>();

  public MyAdapter(MainActivity parentActivity) {
    this.parentActivity = parentActivity;
  }
  
  public MyAdapter(MultiListActivity multiListActivity) {
    // TODO Auto-generated constructor stub
  }

  public void addElements(List<Tweet> tweets) {
    data = tweets;
    notifyDataSetChanged();
  }

  public void addElement(Tweet tweet, RowType type) {
    int position = getCount();
    switch (type) {
      case ROW1:
        arrayPositionsRow1.add(position);
        break;
      case ROW2:
        arrayPositionsRow2.add(position);
        break;
      case ROW3:
        arrayPositionsRow3.add(position);
        break;

      default:
        break;
    }
    data.add(tweet);
    notifyDataSetChanged();
  }

  public void clear() {
    data.clear();
  }

  @Override
  public int getCount() {
    return data.size();
  }

  @Override
  public Object getItem(int position) {
    return data.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }
  
  @Override
  public int getViewTypeCount() {
    return 3;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder viewholder = null;
    int rowType = getItemViewType(position);

    if (convertView == null) {
      // first time creating list view
      Log.e(myTag, "creating new row for position: " + position);
      int layoutId = 0;
      if (rowType == 0) {
        // row 1
        layoutId = R.layout.row1;
        viewholder = new ViewHolderTV();
      } else if (rowType == 1) {
        // row 2
        layoutId = R.layout.row2;
        viewholder = new ViewHolderTV();
      } else {
        // row 3
        layoutId = R.layout.row3;
        viewholder = new ViewHolderRB();
      }
      convertView = parentActivity.getLayoutInflater().inflate(layoutId, null);

      if (rowType == 2) {
        layoutId = R.layout.row1;
        ViewHolderRB viewHolderRB = (ViewHolderRB) viewholder;
        viewHolderRB.setRadioButton((RadioButton) convertView.findViewById(R.id.rbName));
      } else {
        // row 1 or 2
        layoutId = R.layout.row3;
        ViewHolderTV viewHolderTV = (ViewHolderTV) viewholder;
        viewHolderTV.setTextView((TextView) convertView.findViewById(R.id.txtName));
      }

      convertView.setTag(viewholder);
    } else {
      Log.e(myTag, "getView: existing view, changing content for position: " + position);
      viewholder = (ViewHolder) convertView.getTag();
    }

    // changing content
    Tweet tweet = (Tweet) getItem(position);

    if (rowType == 2) {
      ViewHolderRB viewHolderRB = (ViewHolderRB) viewholder;
      viewHolderRB.getRadioButton().setText(tweet.getTweet());
    } else {
      // row 1 or 2
      ViewHolderTV viewHolderTV = (ViewHolderTV) viewholder;
      viewHolderTV.getTextView().setText(tweet.getTweet());
    }

    return convertView;
  }

  @Override
  public int getItemViewType(int position) {
    if (arrayPositionsRow1.contains(position)) {
      return RowType.ROW1.ordinal();
    } else if (arrayPositionsRow2.contains(position)) {
      return RowType.ROW2.ordinal();
    } else if (arrayPositionsRow3.contains(position)) {
      return RowType.ROW3.ordinal();
    }
    return super.getItemViewType(position);
  }

  public void addElement(String string, RowType row1) {
    // TODO Auto-generated method stub
    
  }
}