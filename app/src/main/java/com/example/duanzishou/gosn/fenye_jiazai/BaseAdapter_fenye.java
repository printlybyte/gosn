package com.example.duanzishou.gosn.fenye_jiazai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.duanzishou.gosn.Adapter_gson;
import com.example.duanzishou.gosn.Person;
import com.example.duanzishou.gosn.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/21.
 */

public class BaseAdapter_fenye extends BaseAdapter{
    private Context mContext;
    private List<Student> mList = new ArrayList<>();

    public BaseAdapter_fenye(Context mContext, List<Student> mList) {
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
        viewHodle.textView2.setText(mList.get(position).getName());
        return convertView;

    }

    class ViewHodle {
        TextView textView;
        TextView textView2;
    }
}
