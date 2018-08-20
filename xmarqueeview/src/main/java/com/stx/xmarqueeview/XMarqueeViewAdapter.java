package com.stx.xmarqueeview;

import android.view.View;

import java.util.List;

/**
 * author: xiaohaibin.
 * time: 2018/6/4
 * mail:xhb_199409@163.com
 * github:https://github.com/xiaohaibin
 * describe: XMarqueeViewAdapter
 */
public abstract class XMarqueeViewAdapter<T> {

    protected List<T> mDatas;
    private OnDataChangedListener mOnDataChangedListener;

    public XMarqueeViewAdapter(List<T> datas) {
        this.mDatas = datas;
        if (datas == null || datas.isEmpty()) {
            throw new RuntimeException("Nothing to Show With XMarqueeView");
        }
    }

    public void setData(List<T> datas) {
        this.mDatas = datas;
        notifyDataChanged();
    }

    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public abstract View onCreateView(XMarqueeView parent);

    public abstract void onBindView(View parent, View view, int position);

    public void setOnDataChangedListener(OnDataChangedListener onDataChangedListener) {
        mOnDataChangedListener = onDataChangedListener;
    }

    public void notifyDataChanged() {
        if (mOnDataChangedListener != null) {
            mOnDataChangedListener.onChanged();
        }
    }

    public interface OnDataChangedListener {
        void onChanged();
    }
}
