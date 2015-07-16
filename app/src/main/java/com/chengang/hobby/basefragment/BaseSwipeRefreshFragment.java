package com.chengang.hobby.basefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.chengang.hobby.R;

import butterknife.Bind;

/**
 * ȫ下拉刷新界面的基类
 *
 * @author chengang (https://github.com/developerchengang)
 * @version 1.0
 * @created 2015-07-10
 */
public abstract class BaseSwipeRefreshFragment<T> extends BaseFragment implements
        SwipeRefreshLayout.OnRefreshListener,AbsListView.OnScrollListener,AdapterView.OnItemClickListener{

    // 没有状态
    public static final int LISTVIEW_ACTION_NONE = -1;

    // 初始化时，加载缓存状态
    public static final int LISTVIEW_ACTION_INIT = 0;

    // 加载中
    public static final int LISTVIEW_ACTION_LOADING = 1;

    // 刷新状态，显示toast
    public static final int LISTVIEW_ACTION_REFRESH = 2;

    // 下拉到底部时，获取下一页的状态
    public static final int LISTVIEW_ACTION_SCROLL = 3;

    // 当前数据状态，如果是已经全部加载，则不再执行滚动到底部就加载的情况
    private int dataState = LISTVIEW_ACTION_NONE;

    // ListView底部
    private View mFooterView;

    // ListView底部进度条
    private View mFooterProgressBar;

    // ListView底部提示文字
    private TextView mFooterTextView;

    // 下拉刷新
    @Bind(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Bind(R.id.listView)
    ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFooterView = inflater.inflate(R.layout.listview_footer, null);
        /*mFooterProgressBar = mFooterView.findViewById(R.id.listview_foot_progress);
        mFooterTextView = (TextView) mFooterView.findViewById(R.id.listview_foot_more);*/
        return inflater.inflate(R.layout.base_swiperefresh, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        setupListView();
    }


    @Override
    public void onRefresh() {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // 点击了底部
        if (view == mFooterView){
          return;
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    private void initView(){
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(R.color.swiperefresh_color1,
                R.color.swiperefresh_color2, R.color.swiperefresh_color3,
                R.color.swiperefresh_color4);
    }

    private void setupListView(){
        mListView.setOnScrollListener(this);
        mListView.setOnItemClickListener(this);
        mListView.addFooterView(mFooterView);
    }

    /**
     * 设置顶部正在加载的状态
     */
    void setSwipeRefreshLoadingState(){
        if (mSwipeRefreshLayout != null){
            mSwipeRefreshLayout.setRefreshing(true);
            // 防止多次重复刷新
            mSwipeRefreshLayout.setEnabled(false);
        }
    }

    /**
     * 设置顶部加载完毕的状态
     */
    void setSwipeRefreshLoadedState(){
        if (mSwipeRefreshLayout != null){
            mSwipeRefreshLayout.setRefreshing(false);
            mSwipeRefreshLayout.setEnabled(true);
        }
    }

    /**
     * 设置底部加载中的状态
     */
    void setFooterLoadingState(){
        if (mFooterView != null){
            mFooterProgressBar.setVisibility(View.VISIBLE);
            mFooterTextView.setText(R.string.load_ing);
        }
    }

    /**
     * 设置底部已加载全部的状态
     */
    void setFooterFullState(){
        if (mFooterView != null){
            mFooterProgressBar.setVisibility(View.GONE);
            mFooterTextView.setText(R.string.load_full);
        }
    }
}
