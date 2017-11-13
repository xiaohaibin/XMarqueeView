package com.stx.xmarqueeview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.xhb.xmarqueeview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 仿淘宝首页的 淘宝头条滚动的自定义View
 * <p>
 * Created by jxnk25 on 2017/11/03.
 */
public class XMarqueeView extends ViewFlipper {
    /**
     * 是否设置动画时间间隔
     */
    private boolean isSetAnimDuration = false;

    /**
     * 是否单行显示
     */
    private boolean isSingleLine = false;

    /**
     * 轮播间隔
     */
    private int interval = 3000;

    /**
     * 动画时间
     */
    private int animDuration = 1000;
    private int textSize = 14;
    private int textColor = Color.parseColor("#888888");

    public XMarqueeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.XMarqueeView, defStyleAttr, 0);
        if (typedArray != null) {
            isSetAnimDuration = typedArray.getBoolean(R.styleable.XMarqueeView_isSetAnimDuration, false);
            isSingleLine = typedArray.getBoolean(R.styleable.XMarqueeView_isSingleLine, false);
            interval = typedArray.getInteger(R.styleable.XMarqueeView_marquee_interval, interval);
            animDuration = typedArray.getInteger(R.styleable.XMarqueeView_marquee_animDuration, animDuration);
            if (typedArray.hasValue(R.styleable.XMarqueeView_marquee_textSize)) {
                textSize = (int) typedArray.getDimension(R.styleable.XMarqueeView_marquee_textSize, textSize);
                textSize = Utils.px2sp(context, textSize);
            }
            textColor = typedArray.getColor(R.styleable.XMarqueeView_marquee_textColor, textColor);
            typedArray.recycle();
        }
        Animation animIn = AnimationUtils.loadAnimation(context, R.anim.anim_marquee_in);
        Animation animOut = AnimationUtils.loadAnimation(context, R.anim.anim_marquee_out);
        if (isSetAnimDuration) {
            animIn.setDuration(animDuration);
            animOut.setDuration(animDuration);
        }
        setInAnimation(animIn);
        setOutAnimation(animOut);
        setFlipInterval(interval);
    }

    /**
     * 设置循环滚动的View数组
     *
     * @param views
     */
    private void setViews(final List<View> views) {
        if (views == null || views.size() == 0) {
            return;
        }
        removeAllViews();
        for (int i = 0; i < views.size(); i++) {
            final int position = i;
            views.get(i).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(position, views.get(position));
                    }
                }
            });
            ViewGroup viewGroup = (ViewGroup) views.get(i).getParent();
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            addView(views.get(i));
        }
        startFlipping();
    }


    public void setData(List<String> data) {
        setData(R.layout.marqueeview_item_view, data);
    }

    public void setData(@LayoutRes int layoutId, List<String> data) {
        if (data.isEmpty()) {
            return;
        }
        List<View> viewList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            LinearLayout moreView = (LinearLayout) LayoutInflater.from(getContext()).inflate(layoutId, null);
            TextView tvOne = (TextView) moreView.findViewById(R.id.marquee_tv_one);
            TextView tvTwo = (TextView) moreView.findViewById(R.id.marquee_tv_two);
            if (tvOne != null) {
                tvOne.setTextSize(textSize);
                tvOne.setTextColor(textColor);
                tvOne.setText(data.get(i));
            } else {
                throw new RuntimeException("Please set the first TextView Id With marquee_tv_one !");
            }
            if (tvTwo != null) {
                tvTwo.setTextSize(textSize);
                tvTwo.setTextColor(textColor);
                if (!isSingleLine && data.size() > i + 1) {
                    tvTwo.setText(data.get(i + 1));
                } else {
                    moreView.findViewById(R.id.marquee_tv_two).setVisibility(View.GONE);
                }
            } else {
                throw new RuntimeException("Please set the second TextView Id With marquee_tv_two !");
            }
            viewList.add(moreView);
        }
        setViews(viewList);
    }


    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position, View view);
    }
}
