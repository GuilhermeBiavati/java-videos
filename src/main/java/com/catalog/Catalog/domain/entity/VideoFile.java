package com.catalog.Catalog.domain.entity;

import java.text.DecimalFormat;

public class VideoFile {

    private String title;
    private Float duration;
    private String url;

    // public VideoFile() {
    // }

    public VideoFile(String title, Float duration, String url) {
        setTitle(title);
        setDuration(duration);
        setUrl(url);
    }

    public VideoFile(String title, Float duration) {
        setTitle(title);
        setDuration(duration);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        if (title == null)
            throw new IllegalArgumentException("name is marked non-null but is null");
        if (title.length() == 0)
            throw new IllegalArgumentException("title is marked not-blank but is not-blank");
        this.title = title;
    }

    public Float getDuration() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Float.valueOf(decimalFormat.format(this.duration));
    }

    public void setDuration(Float duration) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        this.duration = Float.valueOf(decimalFormat.format(duration));
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
