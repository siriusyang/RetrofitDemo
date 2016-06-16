package com.siriusyang.retrofitdemo.myinterface;

import com.siriusyang.retrofitdemo.modle.Subject;

import java.util.List;

/**
 * Created by jack on 2016/6/16.
 */
public class MovieEntity {

    List<Movies> movieEntity;
    /**
     * count : 10
     * start : 0
     * total : 250
     * title : 豆瓣电影Top250
     */

    private int count;
    private int start;
    private int total;
    private String title;
    List<Subject> subjectList;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
