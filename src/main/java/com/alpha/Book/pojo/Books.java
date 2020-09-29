package com.alpha.Book.pojo;


public class Books {
    private Integer bookID;
    private String bookName;
    private String uname;

    public Books(Integer bookID, String bookName, String uname, int bookCounts, String detail) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.uname = uname;
        this.bookCounts = bookCounts;
        this.detail = detail;
    }

    private int bookCounts;
    private String detail;

    public Books() {
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", uname='" + uname + '\'' +
                ", bookCounts=" + bookCounts +
                ", detail='" + detail + '\'' +
                '}';
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getBookCounts() {
        return bookCounts;
    }

    public void setBookCounts(int bookCounts) {
        this.bookCounts = bookCounts;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }



}

