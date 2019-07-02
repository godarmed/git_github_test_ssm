package com.leo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Book {
    private Integer id;
    private String bookName;
    private String author;
    private Date publishTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Integer bookType;

    public Book() {
    }

    public Book(Integer id, String bookName, String author, Date publishTime, Integer bookType) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.publishTime = publishTime;
        this.bookType = bookType;
    }

    public Book(String bookName, String author, Date publishTime, Integer bookType) {
        this.bookName = bookName;
        this.author = author;
        this.publishTime = publishTime;
        this.bookType = bookType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publishTime=" + publishTime +
                ", bookType=" + bookType +
                '}';
    }
}
