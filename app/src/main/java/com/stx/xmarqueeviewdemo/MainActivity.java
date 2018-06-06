package com.stx.xmarqueeviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.stx.xmarqueeview.XMarqueeView;
import com.stx.xmarqueeview.XMarqueeViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mDatas = new ArrayList<>();
        mDatas.add("跑马灯内容1");
        mDatas.add("跑马灯内容2");
        mDatas.add("跑马灯内容3");
        mDatas.add("跑马灯内容4");
        mDatas.add("跑马灯内容5");
        mDatas.add("跑马灯内容6");
        mDatas.add("跑马灯内容7");

        XMarqueeView marqueeviewone = (XMarqueeView) findViewById(R.id.marquee1);
        marqueeviewone.setAdapter(new MarqueeViewAdapter(mDatas, this));


        XMarqueeView marqueeviewtwo = (XMarqueeView) findViewById(R.id.marquee2);
        marqueeviewtwo.setAdapter(new MarqueeViewAdapter(mDatas, this));


        XMarqueeView xMarqueeView = (XMarqueeView) findViewById(R.id.marquee3);
        xMarqueeView.setAdapter(new MarqueeViewAdapter(mDatas, this));
        //刷新数据
//        marqueeViewAdapter.setData(mDatas);
    }

}
