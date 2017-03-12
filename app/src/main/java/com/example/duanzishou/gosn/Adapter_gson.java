package com.example.duanzishou.gosn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/20.
 */

public class Adapter_gson extends BaseAdapter {
    private Context mContext;
    private List<Person> mList = new ArrayList<>();

    public Adapter_gson(Context mContext, List<Person> mList) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodle viewHodle = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.gson_list_item, null);
            viewHodle = new ViewHodle();
            viewHodle.textView = (TextView) convertView.findViewById(R.id.gson_list_item1);
            viewHodle.textView2 = (TextView) convertView.findViewById(R.id.gson_list_item2);
            convertView.setTag(viewHodle);

        } else {
            viewHodle = (ViewHodle) convertView.getTag();

        }
        viewHodle.textView.setText(mList.get(position).getTitle());
        viewHodle.textView2.setText(mList.get(position).getImage_url());
        return convertView;

    }

    class ViewHodle {
        TextView textView;
        TextView textView2;
    }
}
