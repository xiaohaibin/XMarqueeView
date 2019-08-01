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
        mMarqueeViewAdapter = new MarqueeViewAdapter(mDatas, this);
        xMarqueeView.setAdapter(mMarqueeViewAdapter);
        Button btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatas.clear();
                for (int i = 0; i < 4; i++) {
                    mDatas.add("这是刷新后的跑马灯内容" + (i + 1));
                }
                //刷新数据
                mMarqueeViewAdapter.setData(mDatas);
            }
        });
    }

}
