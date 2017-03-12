package com.example.duanzishou.gosn.fenye_jiazai;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.duanzishou.gosn.R;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.BitmapCallback;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class fenye_Activity extends AppCompatActivity implements MyOnScrollListener.OnloadDataListener{
    //底部加载更多布局
    View footer;
    private ListView mListFenye;
    private BaseAdapter_fenye adapter;
    private List<Student> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenye_);
        final ImageView imageView= (ImageView) findViewById(R.id.OKGO_image);
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student ss = new Student();
            ss.setName("a" + String.valueOf(i));
            ss.setTitle(i % 2 == 0 ? "男" : "女");
            mList.add(ss);
        }

        onLoadData(mList);
        OkGo.get("https://ss0.baidu.com/73F1bjeh1BF3odCf/it/u=1757569311,589160763&fm=85&s=47721DC796434CFDC101ACF903001012")//
                .tag(this)//
                .execute(new BitmapCallback() {
                    @Override
                    public void onSuccess(Bitmap bitmap, Call call, Response response) {
                        // bitmap 即为返回的图片数据
                        imageView.setImageBitmap(bitmap);
                    }
                });

        //自定义的滚动监听事件
        MyOnScrollListener onScrollListener = new MyOnScrollListener(footer, mList);
        //设置接口回调
        onScrollListener.setOnLoadDataListener(this);
        //设置ListView的滚动监听事件
        mListFenye.setOnScrollListener(onScrollListener);



    }

    private void initView_show(List<Student> data) {

        if (mList != null) {
            if (adapter == null) {
                mListFenye = (ListView) findViewById(R.id.list_fenye);
                //将底部加载一个加载更多的布局
                footer = LayoutInflater.from(this).inflate(R.layout.foot_boot, null);
                footer.setVisibility(View.GONE);
                mListFenye.addFooterView(footer);
                mListFenye.addHeaderView(footer);
                adapter = new BaseAdapter_fenye(this, mList);
                mListFenye.setAdapter(adapter);

            } else {
                this.mList = data;
                adapter.notifyDataSetChanged();
            }

        } else {
            Toast.makeText(this, "mlist=null", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoadData(List<Student> data) {
        initView_show(mList);
    }
}
