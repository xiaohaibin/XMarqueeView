package com.stx.xmarqueeview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.xhb.xmarqueeview.R;

/**
 * 仿淘宝首页的 淘宝头条滚动的自定义View
 * <p>
 * Created by jxnk25 on 2017/11/03.
 */
public class XMarqueeView extends ViewFlipper implements XMarqueeViewAdapter.OnDataChangedListener {

    /**是否设置动画时间间隔*/
    private boolean isSetAnimDuration = false;

    /**是否单行显示*/
    private boolean isSingleLine = true;

    /**轮播间隔*/
    private int interval = 3000;

    /**动画时间*/
    private int animDuration = 1000;
    private int textSize = 14;
    private int textColor = Color.parseColor("#888888");
    /**一次性显示多少个*/
    private int itemCount = 1;

    private XMarqueeViewAdapter mMarqueeViewAdapter;
    /**当数据源少于一次性显示数目是否自动轮播标记*/
    private boolean isFlippingLessCount = true;

    public XMarqueeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.XMarqueeView, defStyleAttr, 0);
        if (typedArray != null) {
            isSetAnimDuration = typedArray.getBoolean(R.styleable.XMarqueeView_isSetAnimDuration, false);
            isSingleLine = typedArray.getBoolean(R.styleable.XMarqueeView_isSingleLine, true);
            isFlippingLessCount = typedArray.getBoolean(R.styleable.XMarqueeView_isFlippingLessCount, true);
            interval = typedArray.getInteger(R.styleable.XMarqueeView_marquee_interval, interval);
            animDuration = typedArray.getInteger(R.styleable.XMarqueeView_marquee_animDuration, animDuration);
            if (typedArray.hasValue(R.styleable.XMarqueeView_marquee_textSize)) {
                textSize = (int) typedArray.getDimension(R.styleable.XMarqueeView_marquee_textSize, textSize);
                textSize = Utils.px2sp(context, textSize);
            }
            textColor = typedArray.getColor(R.styleable.XMarqueeView_marquee_textColor, textColor);
            itemCount = typedArray.getInt(R.styleable.XMarqueeView_marquee_count, itemCount);
            typedArray.recycle();
        }
        isSingleLine = itemCount == 1;
        Animation animIn = AnimationUtils.loadAnimation(context, R.anim.anim_marquee_in);
        Animation animOut = AnimationUtils.loadAnimation(context, R.anim.anim_marquee_out);
        if (isSetAnimDuration) {
            animIn.setDuration(animDuration);
            animOut.setDuration(animDuration);
        }
        setInAnimation(animIn);
        setOutAnimation(animOut);
        setFlipInterval(interval);
        setMeasureAllChildren(false);
    }


    public void setAdapter(XMarqueeViewAdapter adapter) {
        if (adapter == null) {
            throw new RuntimeException("adapter must not be null");
        }
        if (mMarqueeViewAdapter != null) {
            throw new RuntimeException("you have already set an Adapter");
        }
        this.mMarqueeViewAdapter = adapter;
        mMarqueeViewAdapter.setOnDataChangedListener(this);
        setData();
    }

    private void setData() {
        removeAllViews();
        int currentIndex = 0;
        int loopconunt = mMarqueeViewAdapter.getItemCount() % itemCount == 0 ? mMarqueeViewAdapter.getItemCount() / itemCount : mMarqueeViewAdapter.getItemCount() / itemCount + 1;
        for (int i = 0; i < loopconunt; i++) {
            if (isSingleLine) {
                View view = mMarqueeViewAdapter.onCreateView(this);
                mMarqueeViewAdapter.onBindView(view, view, currentIndex);
                currentIndex = currentIndex + 1;
                addView(view);
            } else {
                LinearLayout parentView = new LinearLayout(getContext());
                parentView.setOrientation(LinearLayout.VERTICAL);
                parentView.setGravity(Gravity.CENTER);
                parentView.removeAllViews();
                for (int j = 0; j < itemCount; j++) {
                    View view = mMarqueeViewAdapter.onCreateView(this);
                    parentView.addView(view);
                    mMarqueeViewAdapter.onBindView(parentView, view, getRealPosition(j, currentIndex));
                    currentIndex = getRealPosition(j, currentIndex);
                }
                addView(parentView);
            }
        }
        if (isFlippingLessCount||itemCount>=mMarqueeViewAdapter.getItemCount()) {
            startFlipping();
        }
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public void setSingleLine(boolean singleLine) {
        isSingleLine = singleLine;
    }

    public void setFlippingLessCount(boolean flippingLessCount) {
        isFlippingLessCount = flippingLessCount;
    }

    private int getRealPosition(int index, int currentIndex) {
        if ((index == 0 && currentIndex == 0) ||
                (currentIndex == mMarqueeViewAdapter.getItemCount() - 1
                        && currentIndex % itemCount == 0)) {
            return 0;
        } else {
            return currentIndex + 1;
        }
    }

    @Override
    public void onChanged() {
        setData();
    }

    @Override
    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (VISIBLE == visibility) {
            startFlipping();
        } else if (GONE == visibility || INVISIBLE == visibility) {
            stopFlipping();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startFlipping();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopFlipping();
    }

}
