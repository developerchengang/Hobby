package com.chengang.hobby;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.chengang.hobby.common.LruBitmapCache;

/**
 * ȫ全局应用程序类：用于保存和调用全局应用配置及访问网络数据
 *
 * @author chengang (https://github.com/developerchengang)
 * @version 1.0
 * @created 2015-07-10
 */
public class AppController extends Application{
    public static final String TAG = AppController.class.getSimpleName();

    private static AppController mInstance;

    private RequestQueue mRequestQueue;

    private ImageLoader mImageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized AppController getInstance(){
        return mInstance;
    }

    public RequestQueue getmRequestQueue(){
        if (mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public ImageLoader getImageLoader(){
        getmRequestQueue();
        if (mImageLoader == null){
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache());
        }
        return mImageLoader;
    }

    public <T> void addToRequestQuequ(Request<T> req){
        req.setTag(TAG);
        getmRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req, String tag){
        // 如果为空设置默认tag
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getmRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag){
        if (mRequestQueue != null){
            mRequestQueue.cancelAll(tag);
        }
    }
}
