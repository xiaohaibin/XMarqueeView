package com.stx.xmarqueeviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.stx.xmarqueeview.XMarqueeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> mDatas;
    private MarqueeViewAdapter mMarqueeViewAdapter;
    private XMarqueeView mXMarqueeView;
    private MarqueeViewAdapter mAdapter;

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

        XMarqueeView marqueeviewone = findViewById(R.id.marquee1);
        mAdapter = new MarqueeViewAdapter(mDatas, this);
        marqueeviewone.setAdapter(mAdapter);
        marqueeviewone.stopFlipping();


        XMarqueeView marqueeviewtwo = findViewById(R.id.marquee2);
        marqueeviewtwo.setAdapter(new MarqueeViewAdapter(mDatas, this));


        mXMarqueeView = findViewById(R.id.marquee3);
        mMarqueeViewAdapter = new MarqueeViewAdapter(mDatas, this);
        mXMarqueeView.setAdapter(mMarqueeViewAdapter);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatas.clear();
                for (int i = 0; i < 2; i++) {
                    mDatas.add("这是刷新后的跑马灯内容" + (i + 1));
                }
                //刷新数据
                mMarqueeViewAdapter.setData(mDatas);
            }
        });
    }

}
