package com.chengang.hobby.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * ȫ所有适配器基础类
 *
 * @author chengang (https://github.com/developerchengang)
 * @version 1.0
 * @created 2015-07-11
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {

    // 标识LinkView上的链接，默认为false
    protected boolean isLinkViewClick = false;

    // 上下文
    protected Context mContext;

    // 数据集合
    protected List<T> mListData;

    // 视图容器
    protected LayoutInflater mListContainer;

    //自定义项视图源id
    protected int mItemViewResource;

    public MyBaseAdapter(Context context, List<T> ListData, int resource){
        mContext = context;
        // 创建视图容器并设置上下文
        mListContainer = LayoutInflater.from(mContext);
        mListData = mListData;
        mItemViewResource = resource;
    }

    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public Object getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public boolean isLinkViewClick() {
        return isLinkViewClick;
    }

    public void setLinkViewClick(boolean isLinkViewClick) {
        this.isLinkViewClick = isLinkViewClick;
    }

    public void remove(int position) {
        mListData.remove(position);
    }

}
