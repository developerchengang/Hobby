package com.chengang.hobby.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.chengang.hobby.AppController;
import com.chengang.hobby.R;
import com.chengang.hobby.adapter.MovieAdapter;
import com.chengang.hobby.basefragment.BaseFragment;
import com.chengang.hobby.bean.Result;
import com.chengang.hobby.bean.Subjects;
import com.chengang.hobby.bean.URLs;
import com.chengang.hobby.common.CustomRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 电影界面
 *
 * @author chengang (https://github.com/developerchengang)
 * @version 1.0
 * @created 2015-07-10
 */
public class MovieFragment extends BaseFragment implements
        SwipeRefreshLayout.OnRefreshListener {

    public static final String TAG_POST_MOVIE = "json_post_movie";

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    @Bind(R.id.swipe_refresh_widget)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private ContentLoadingProgressBar progressBar;

    private LinearLayoutManager mLayoutManager;

    private List<Subjects> listData = new ArrayList<>();

    private static String url;

    private JSONObject jsonObject;

    private MovieAdapter adapter;

    private int lastVisibleItem;

    private int mCurrentPage = 0;

    protected int mLastPage = -1;

    private int start;

    private View view;

    private final static int count = 20;

    String jsonString;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                // 下拉刷新数据
                case 0:
                    mSwipeRefreshLayout.setRefreshing(false);
                    mCurrentPage = 0;
                    mLastPage = -1;
                    getData();
                    break;
                // 上拉加载数据
                case 1:
                    getData();
                    break;
            }
        }
    };

    public static MovieFragment newInstance() {
        return new MovieFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url = URLs.TOPMOVIE;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_movie, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mSwipeRefreshLayout.setColorSchemeColors(R.color.swiperefresh_color1,
                R.color.swiperefresh_color2, R.color.swiperefresh_color3,
                R.color.swiperefresh_color4);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        recyclerView.setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE &&
                        lastVisibleItem + 1 == adapter.getItemCount()) {
                    handler.sendEmptyMessageDelayed(1, 3000);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            }
        });

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mCurrentPage = 0;
        getData();

    }


    /**
     * 获取网络数据
     */
    private void getData() {
        if (mCurrentPage <= mLastPage) {
            return;
        }
        mLastPage = mCurrentPage;
        start = mCurrentPage * 20;
        Log.i(TAG_POST_MOVIE, start + "");
        Map<String, String> params = new HashMap<>();
        params.put("start", start + "");
        params.put("count", count + "");
        CustomRequest jsonObjReq = new CustomRequest(
                Request.Method.POST,
                url,
                params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Gson gson = new Gson();
                        jsonObject = response;

                        Result result = new Result();
                        try {
                            result.setCount(jsonObject.getInt("count"));
                            result.setStart(jsonObject.getInt("start"));
                            result.setTotal(jsonObject.getInt("total"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        try {

                            List<Subjects> list = gson.fromJson(jsonObject.getString("subjects"), new TypeToken<List<Subjects>>() {
                            }.getType());
                            if (list != null) {

                                if (mCurrentPage == 0) {
                                    listData.clear();
                                }
                                listData.addAll(list);

                                if (listData != null && listData.size() > 0 &&
                                        adapter == null) {
                                    adapter = new MovieAdapter(getActivity(), listData);
                                    recyclerView.setAdapter(adapter);
                                    mCurrentPage++;
                                } else if (list.size() == 20 && adapter != null) {
                                    adapter.notifyDataSetChanged();
                                    mCurrentPage++;
                                } else if ((list.size() < 20 && listData.size() > 0)
                                        && adapter != null){
                                    adapter.notifyDataSetChanged();
                                }

                                int size = list.size();
                                if (size < 20) {
                                    progressBar = (ContentLoadingProgressBar)
                                            view.findViewById(R.id.progressbar);
                                    progressBar.hide();
                                }

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        AppController.getInstance().addToRequestQueue(jsonObjReq, TAG_POST_MOVIE);
    }

    @Override
    public void onRefresh() {

        if (progressBar != null){
            progressBar.show();
        }

        handler.sendEmptyMessageDelayed(0, 3000);
    }

}
