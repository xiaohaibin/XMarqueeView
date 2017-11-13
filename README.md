# XMarqueeView
类似淘宝头条、京东头条的跑马灯效果，上下轮播，支持单行/双行显示

## 主要功能：
- 支持单/双行轮播显示
- 支持自定义轮播布局
- 支持自定义轮播效果


## 效果图

![1](https://github.com/xiaohaibin/CustomTitileBar/blob/master/screenshot/gif.gif)

## 基本使用

 [ ![Download](https://api.bintray.com/packages/jxnk25/maven/CommonTitleBar/images/download.svg) ](https://bintray.com/jxnk25/maven/CommonTitleBar/_latestVersion)

#### 1.添加Gradle依赖

```
dependencies {
    compile 'compile 'com.xhb:commontitlebar:latestVersion'//将latestVersion替换成上面最新的版本号
}
```

#### 2.在布局文件中添加

```
    <com.stx.xhb.commontitlebar.CustomTitlebar
        android:id="@+id/title3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:title_text="标题"
        app:left_button_image="@mipmap/icon_back"
        app:title_textSize="14sp"
        app:right_button_image="@mipmap/img_currency_selected"/>
```


#### 3.在Activity或者Fragment中配置

```
        CustomTitlebar customTitlebar2 = (CustomTitlebar) findViewById(R.id.title2);
        customTitlebar2.setAction(new CustomTitlebar.TitleBarOnClickListener() {
            @Override
            public void performAction(View view) {
                switch (view.getId()){
                    case R.id.iv_left:
                        Toast.makeText(MainActivity.this, "左边图片按钮", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tv_right:
                        Toast.makeText(MainActivity.this, "右边文字按钮", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

```


## 自定义属性说明

| 属性名 | 属性说明 | 属性值 | 
| ------------ | ------------- | ------------ |
| title_background| 标题栏背景色 | color，默认为white |
| left_button_image| 左边图片按钮背景 | reference ，不设置则不显示|
| left_button_text| 左边文字按钮内容 |string |
| left_button_textColor| 左边文字按钮文字颜色 | color，默认为Color.GRAY |
| left_button_textSize| 左边文字按钮文字大小 | dimension，默认为14sp |
| title_text| 标题文字内容 | string |
| title_textColor| 标题文字颜色 |color，默认为Color.GRAY |
| title_textSize| 标题文字大小| dimension，默认为14sp |
| right_button_image| 右边图片按钮背景 |reference  ，不设置则不显示|
| right_button_text| 右边文字按钮内容 | string |
| right_button_textColor| 右边文字颜色 | color，默认为Color.GRAY |
| right_button_textSize| 右边文字大小 | dimension，默认为14sp |
| show_line| 是否显示顶部分割线 | booleanT类型，默认显示 |

## 关于我
个人邮箱：xhb_199409@163.com

[GitHub主页](https://github.com/xiaohaibin)

[简书主页](http://www.jianshu.com/users/42aed90cf5af/latest_articles)

[个人博客](http://blog.csdn.net/jxnk25)


##如果觉得文章帮到你，不求打赏，喜欢我的文章可以关注我和朋友一起运营的微信公众号，将会定期推送优质技术文章，求关注~~~##

![欢迎关注“大话安卓”微信公众号](http://upload-images.jianshu.io/upload_images/1956769-2f49dcb0dc5195b6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

##欢迎加入“大话安卓”技术交流群，一起分享，共同进步##
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
    
#如果喜欢，还请statr&Fork&follow进行支持，谢谢O(∩_∩)O~。#
