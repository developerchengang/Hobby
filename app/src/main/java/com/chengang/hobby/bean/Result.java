package com.chengang.hobby.bean;

/**
 * 从服务器返回数据结果
 *
 * @author chengang (https://github.com/developerchengang)
 * @version 1.0
 * @created 2015-07-13
 */
public class Result {

    // 当前从服务器返回的数据个数
    private int count;

    // 当前从服务器请求数据起始位置
    private int start;

    // 请求的URL总数据
    private int total;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
