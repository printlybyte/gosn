package com.example.duanzishou.gosn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private String wangzhi = "http://123.56.237.2:8080/open.php?c=activity&m=getlist";
    private List<Person> mList_xx = new ArrayList<>();
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.gson_testList);
        //以下代码是将json数据自动解析成一个javaBean对象
        post();
    }

    private void post() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url(wangzhi).build();
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    String resultttt = response.body().string();
                    gson_jiexi(resultttt);
                    //  Log.i("qqww", resultttt);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }

    private void gson_jiexi(String aa) {
        Gson gg = new Gson();//初始化
        javaBean jj = gg.fromJson(aa, javaBean.class);
        List<javaBean.DataBean> mlist = jj.getData();
        for (int i = 0; i < mlist.size(); i++) {
            Person pp = new Person();
            pp.setTitle(mlist.get(i).getItem_title());
            pp.setImage_url(mlist.get(i).getPoster_img());
            mList_xx.add(pp);
        }
        Adapter_gson adapter = new Adapter_gson(MainActivity.this, mList_xx);
        listview.setAdapter(adapter);

    }
}
