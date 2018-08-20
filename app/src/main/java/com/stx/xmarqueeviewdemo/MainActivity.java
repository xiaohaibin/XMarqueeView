package com.stx.xmarqueeviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.stx.xmarqueeview.XMarqueeView;

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
        for (int i = 0; i < 7; i++) {
            mDatas.add("这是跑马灯内容" + (i + 1));
        }

        XMarqueeView marqueeviewone = (XMarqueeView) findViewById(R.id.marquee1);
        marqueeviewone.setAdapter(new MarqueeViewAdapter(mDatas, this));
        marqueeviewone.stopFlipping();


        XMarqueeView marqueeviewtwo = (XMarqueeView) findViewById(R.id.marquee2);
        marqueeviewtwo.setAdapter(new MarqueeViewAdapter(mDatas, this));


        XMarqueeView xMarqueeView = (XMarqueeView) findViewById(R.id.marquee3);
        xMarqueeView.setAdapter(new MarqueeViewAdapter(mDatas, this));

        //刷新数据
//        marqueeViewAdapter.setData(mDatas);
    }

}
