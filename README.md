# XMarqueeView
类似淘宝头条、京东头条的跑马灯效果，上下轮播，支持单行/双行显示

## 主要功能：
- 支持单/双行轮播显示
- 支持自定义轮播布局
- 支持自定义轮播效果


## 效果图

![1](https://github.com/xiaohaibin/XMarqueeView/blob/master/screenshot/gif.gif)

## Demo下载

![1](https://github.com/xiaohaibin/XMarqueeView/blob/master/apk/apk.png)

## 基本使用

 [![Download](https://api.bintray.com/packages/jxnk25/maven/XMarqueeView/images/download.svg) ](https://bintray.com/jxnk25/maven/XMarqueeView/_latestVersion)

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
            android:layout_height="match_parent"
            android:layout_weight="1" />
```


#### 3.代码中使用

```
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
```


## 自定义属性说明

| 属性名 | 属性说明 | 属性值 | 
| ------------ | ------------- | ------------ |
| isSetAnimDuration| 是否设置动画时间间隔 | boolean，默认为false |
| isSingleLine| 是否单行显示 | boolean ，默认false双行显示|
| marquee_interval| 轮播间隔 ，轮播间隔|int类型，默认3000ms |
| marquee_animDuration| 轮播动画执行时间 | int类型，默认为1000ms |
| marquee_textSize| 轮播字体大小 | dimension，默认为14sp |
| marquee_textColor|轮播字体颜色 | color，默认为 #888888 |

## 关于我
个人邮箱：xhb_199409@163.com

[GitHub主页](https://github.com/xiaohaibin)

[简书主页](http://www.jianshu.com/users/42aed90cf5af/latest_articles)

[个人博客](http://www.jxnk25.club)


## 如果觉得文章帮到你，不求打赏，喜欢我的文章可以关注我和朋友一起运营的微信公众号，将会定期推送优质技术文章，求关注~~~

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
