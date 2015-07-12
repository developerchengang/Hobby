package com.chengang.hobby.bean;

/**
 * Created by Administrator on 15-7-4.
 */
public class RatingEntity {
    /**
     * average : 9.6
     * min : 0
     * max : 10
     * stars : 50
     */
    private double average;
    private int min;
    private int max;
    private String stars;

    public void setAverage(double average) {
        this.average = average;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public double getAverage() {
        return average;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public String getStars() {
        return stars;
    }
}
