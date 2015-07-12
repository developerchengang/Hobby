package com.chengang.hobby.bean;

import java.util.List;

/**
 * Created by Administrator on 15-7-4.
 */
public class Subjects {


    /**
     * images : {"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p480747492.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p480747492.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p480747492.jpg"}
     * casts : [{"alt":"http://movie.douban.com/celebrity/1054521/","name":"蒂姆·罗宾斯","id":"1054521","avatars":{"small":"http://img3.douban.com/img/celebrity/small/17525.jpg","large":"http://img3.douban.com/img/celebrity/large/17525.jpg","medium":"http://img3.douban.com/img/celebrity/medium/17525.jpg"}},{"alt":"http://movie.douban.com/celebrity/1054534/","name":"摩根·弗里曼","id":"1054534","avatars":{"small":"http://img3.douban.com/img/celebrity/small/34642.jpg","large":"http://img3.douban.com/img/celebrity/large/34642.jpg","medium":"http://img3.douban.com/img/celebrity/medium/34642.jpg"}},{"alt":"http://movie.douban.com/celebrity/1041179/","name":"鲍勃·冈顿","id":"1041179","avatars":{"small":"http://img4.douban.com/img/celebrity/small/5837.jpg","large":"http://img4.douban.com/img/celebrity/large/5837.jpg","medium":"http://img4.douban.com/img/celebrity/medium/5837.jpg"}}]
     * original_title : The Shawshank Redemption
     * subtype : movie
     * year : 1994
     * genres : ["犯罪","剧情"]
     * directors : [{"alt":"http://movie.douban.com/celebrity/1047973/","name":"弗兰克·德拉邦特","id":"1047973","avatars":{"small":"http://img3.douban.com/img/celebrity/small/230.jpg","large":"http://img3.douban.com/img/celebrity/large/230.jpg","medium":"http://img3.douban.com/img/celebrity/medium/230.jpg"}}]
     * rating : {"average":9.6,"min":0,"max":10,"stars":"50"}
     * alt : http://movie.douban.com/subject/1292052/
     * id : 1292052
     * title : 肖申克的救赎
     * collect_count : 842094
     */
    private ImagesEntity images;
    private List<CastsEntity> casts;
    private String original_title;
    private String subtype;
    private String year;
    private List<String> genres;
    private List<DirectorsEntity> directors;
    private RatingEntity rating;
    private String alt;
    private String id;
    private String title;
    private int collect_count;

    public void setImages(ImagesEntity images) {
        this.images = images;
    }

    public void setCasts(List<CastsEntity> casts) {
        this.casts = casts;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public void setDirectors(List<DirectorsEntity> directors) {
        this.directors = directors;
    }

    public void setRating(RatingEntity rating) {
        this.rating = rating;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public ImagesEntity getImages() {
        return images;
    }

    public List<CastsEntity> getCasts() {
        return casts;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getYear() {
        return year;
    }

    public List<String> getGenres() {
        return genres;
    }

    public List<DirectorsEntity> getDirectors() {
        return directors;
    }

    public RatingEntity getRating() {
        return rating;
    }

    public String getAlt() {
        return alt;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCollect_count() {
        return collect_count;
    }

}
