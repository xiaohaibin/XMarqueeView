package com.stx.xmarqueeviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.stx.xmarqueeview.XMarqueeView;
import com.stx.xmarqueeview.XMarqueeViewAdapter;
import com.stx.xmarqueeview.XMarqueeViewCopy;

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
//        mDatas.add("跑马灯内容7");

        XMarqueeView marqueeviewone = (XMarqueeView) findViewById(R.id.upview1);
        //自定义轮播布局，务必要将子自定义布局中的两个TextView 的ID  分别设置为marquee_tv_one  marquee_tv_two
        marqueeviewone.setData(R.layout.custom_item_view, mDatas);
        marqueeviewone.setOnItemClickListener(new XMarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(MainActivity.this, mDatas.get(position), Toast.LENGTH_SHORT).show();
            }
        });


        XMarqueeView marqueeviewtwo = (XMarqueeView) findViewById(R.id.upview2);
        marqueeviewtwo.setData(mDatas);
        marqueeviewtwo.setOnItemClickListener(new XMarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(MainActivity.this, mDatas.get(position), Toast.LENGTH_SHORT).show();
            }
        });


        XMarqueeViewCopy xMarqueeViewCopy = (XMarqueeViewCopy) findViewById(R.id.test);
        XMarqueeViewAdapter<String> marqueeViewAdapter = new XMarqueeViewAdapter<String>(mDatas) {
            @Override
            public View onCreateView(XMarqueeViewCopy parent) {
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.marqueeview_item, null);
            }

            @Override
            public void onBindView(View view, int position) {
                TextView tvOne = (TextView) view.findViewById(R.id.marquee_tv_one);
                tvOne.setText(mDatas.get(position));
            }
        };
        xMarqueeViewCopy.setAdapter(marqueeViewAdapter);
        //刷新数据
//        marqueeViewAdapter.setData(mDatas);
    }

}
