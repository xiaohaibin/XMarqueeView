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
        data.add("花鲢（大头鱼）成交1000.0斤!徐克强于11月06日在成都市以56.00斤单价成交");
        data.add("草鱼（鲩鱼）成交1000.0斤!徐克强于11月06日在成都市以56.00单价成交");
        data.add("草鱼（鲩鱼）成交1000.0斤!徐克强于11月06日在成都市以56.00单价成交");
        data.add("牡蛎成交1000.0斤!徐克强于11月06日在成都市以56.00单价成交");
        data.add("草鱼（鲩鱼）成交1000.0斤!徐克强于11月06日在成都市以56.00单价成交");
        data.add("草鱼（鲩鱼）成交1000.0斤!于11月06日在成都市以56.00单价成交");

        XMarqueeView marqueeviewone= (XMarqueeView) findViewById(R.id.upview1);
        //自定义轮播布局，务必要将子自定义布局中的两个TextView 的ID  分别设置为marquee_tv_one  marquee_tv_two
        marqueeviewone.setData(R.layout.custom_item_view,data);
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
