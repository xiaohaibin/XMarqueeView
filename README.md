 [![Version](https://api.bintray.com/packages/jxnk25/maven/XMarqueeView/images/download.svg) ](https://bintray.com/jxnk25/maven/XMarqueeView/_latestVersion) 
 [![API](https://img.shields.io/badge/API-15%2B-green.svg)]()
 [![License](https://img.shields.io/badge/License-Apache--2.0-green.svg)]()

# XMarqueeView
类似淘宝头条、京东头条的跑马灯效果，上下轮播，支持单行/双行显示

## 主要功能：
- 支持自定义轮播布局
- 支持自定义轮播效果
- 支持单/多行轮播显示，随意定制显示条目


## 效果图

![1](https://github.com/xiaohaibin/XMarqueeView/blob/master/screenshot/gif.gif)

## 基本使用

#### 1.添加Gradle依赖

```
dependencies {
   compile 'com.xhb:xmarqueeview:latestVersion'//将latestVersion替换成上面最新的版本号
}
```

#### 2.在布局文件中添加

```
   <com.stx.xmarqueeview.XMarqueeView
            android:id="@+id/upview2"
            android:layout_width="0dp"
            app:isSingleLine="true"
            app:isSetAnimDuration="true"
            app:marquee_count="3"
            android:layout_height="match_parent"
            android:layout_weight="1" />
```


#### 3.创建MarqueeView适配器

```

public class MarqueeViewAdapter extends XMarqueeViewAdapter<String> {

    private Context mContext;
    public MarqueeViewAdapter(List<String> datas, Context context) {
        super(datas);
        mContext = context;
    }

    @Override
    public View onCreateView(XMarqueeView parent) {
        //跑马灯单个显示条目布局，自定义
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.marqueeview_item, null);
    }

    @Override
    public void onBindView(View parent, View view, final int position) {
        //布局内容填充
        TextView tvOne = (TextView) view.findViewById(R.id.marquee_tv_one);
        tvOne.setText(mDatas.get(position));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "position" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
```

#### 4.数据设置

```
        List<String> data = new ArrayList<>();
        data.add("神奇宝贝（精灵宝可梦）有哪些著名的梗？");
        data.add("我翻开自我保护的书，上面只写了两个大字：证据");
        data.add("接纳自己，是无条件地爱，包括爱所有的痛苦");
        data.add("3 岁前，世界对待孩子的一切，都会给他们留下深刻的第一印象");
        data.add("担心今天没锻炼，现在站起来，做一组完美深蹲");

        XMarqueeView xMarqueeView = (XMarqueeView) findViewById(R.id.marquee3);
        xMarqueeView.setAdapter(new MarqueeViewAdapter(data, this));
        //刷新数据
        //marqueeViewAdapter.setData(data);
```

#### 5.重影问题可参考以下解决方案

    @Override
    public void onStart() {
        super.onStart(); 
        marqueeView.startFlipping();
    }

    @Override
    public void onStop() {
        super.onStop();
        marqueeView.stopFlipping();
    }

## 自定义属性说明

| 属性名 | 属性说明 | 属性值 | 
| ------------ | ------------- | ------------ |
| isSetAnimDuration| 是否设置动画时间间隔 | boolean，默认为false |
| isSingleLine| 是否单行显示 | boolean ，默认true 单行显示|
| marquee_interval| 轮播间隔 ，轮播间隔|int类型，默认3000ms |
| marquee_animDuration| 轮播动画执行时间 | int类型，默认为1000ms |
| marquee_textSize| 轮播字体大小 | dimension，默认为14sp |
| marquee_textColor|轮播字体颜色 | color，默认为 #888888 |
| marquee_count|轮播显示条目数量 | int类型，默认为 1，单行显示|

## 关于我

* **Email**: <xhb_199409@163.com>
* **Home**: <http://www.jxnk25.club>
* **掘金**: <https://juejin.im/user/56fcba0a71cfe4005ca1a57b>
* **简书**: <http://www.jianshu.com/users/42aed90cf5af/latest_articles>


## 如果觉得文章帮到你，喜欢我的文章可以关注我和朋友一起运营的微信公众号，将会定期推送优质技术文章，求关注~~~

![欢迎关注“大话安卓”微信公众号](http://upload-images.jianshu.io/upload_images/1956769-2f49dcb0dc5195b6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


## 欢迎加入“大话安卓”技术交流群，一起分享，共同进步
![欢迎加入“大话安卓”技术交流群，互相学习提升](http://upload-images.jianshu.io/upload_images/1956769-326c166b86ed8e94.JPG?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

License
--
    Copyright (C) 2016 xhb_199409@163.com

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    
# 如果喜欢，还请statr&Fork&follow进行支持，谢谢！
