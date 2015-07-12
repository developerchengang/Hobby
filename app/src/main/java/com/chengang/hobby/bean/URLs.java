package com.chengang.hobby.bean;

/**
 * Created by Administrator on 15-7-4.
 */
public class URLs {

    public final static String HTTP = "http://";

    public final static String HTTPS = "https://";

    public final static String HOST = "api.douban.com";

    public final static String API_VERSION = "v2";

    public final static String URL_SPLITTER = "/";

    // 拼接的api根地址
    public final static String URL_HTTPS_HOST = HTTPS + HOST + URL_SPLITTER;

    public final static String MOVIE = "movie";

    // https://api.douban.com/v2/movie/top250
    public final static String TOPMOVIE = URL_HTTPS_HOST + API_VERSION + URL_SPLITTER + MOVIE+ URL_SPLITTER + "top250";
}
