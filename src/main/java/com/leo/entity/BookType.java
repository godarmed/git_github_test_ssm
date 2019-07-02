package com.leo.entity;

public class BookType {
    private Integer bookTypeId;
    private String bookType;

    public BookType() {
    }

    public BookType(Integer bookTypeId, String bookType) {
        this.bookTypeId = bookTypeId;
        this.bookType = bookType;
    }

    public Integer getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(Integer bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "bookTypeId=" + bookTypeId +
                ", bookType='" + bookType + '\'' +
                '}';
    }
}
