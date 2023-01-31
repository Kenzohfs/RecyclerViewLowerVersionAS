package com.example.recyclerviewlowerversionas.model.entities;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String resume;
    private String publisher;
    private Integer year;
    private transient Drawable image;

    @Override
    public String toString() {
        return "Book \n" +
                "title:'" + title + '\'' +
                "\nresume:'" + resume + '\'' +
                "\npublisher:'" + publisher + '\'' +
                "\nyear:" + year +
                "\nimage:" + image;
    }

    public Book(String title, String resume, String publisher, Integer year, Drawable image) {
        this.title = title;
        this.resume = resume;
        this.publisher = publisher;
        this.year = year;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
