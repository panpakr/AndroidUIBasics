package com.example.androiduibasics.list;

public class TestData {

    private String imgURL;
    private String title;
    private String time;

    public TestData(String imgURL, String title, String time) {
        this.imgURL = imgURL;
        this.title = title;
        this.time = time;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
