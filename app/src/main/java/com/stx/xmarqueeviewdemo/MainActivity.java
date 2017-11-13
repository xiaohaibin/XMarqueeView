package com.stx.xmarqueeviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.stx.xmarqueeview.XMarqueeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        final List<String> data = new ArrayList<>();
        data.add("神奇宝贝（精灵宝可梦）有哪些著名的梗？");
        data.add("我翻开自我保护的书，上面只写了两个大字：证据");
        data.add("接纳自己，是无条件地爱，包括爱所有的痛苦");
        data.add("3 岁前，世界对待孩子的一切，都会给他们留下深刻的第一印象");
        data.add("担心今天没锻炼，现在站起来，做一组完美深蹲");

        XMarqueeView marqueeviewone= (XMarqueeView) findViewById(R.id.upview1);
        marqueeviewone.setData(data);
        marqueeviewone.setOnItemClickListener(new XMarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(MainActivity.this, data.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        XMarqueeView marqueeviewtwo= (XMarqueeView) findViewById(R.id.upview2);
        marqueeviewtwo.setData(data);
        marqueeviewtwo.setOnItemClickListener(new XMarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(MainActivity.this, data.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
