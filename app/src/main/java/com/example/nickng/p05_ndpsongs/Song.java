package com.example.nickng.p05_ndpsongs;

import java.io.Serializable;

/**
 * Created by 15056201 on 18/5/2017.
 */

public class Song implements Serializable {
    private int _id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(int _id, String title, String singers, int year, int stars) {
        this._id=_id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }



    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
