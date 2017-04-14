package com.cn.ask.model;

import java.util.Date;

public class Book {
    private Integer bookId;

    private String bookName;

    private String bookAuthor;

    private Date isupdate;

    private String coverPic;

    private String info;

    private Integer state;

    private String fontNum;

    private String bookUrl;

    private Integer chapter;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor == null ? null : bookAuthor.trim();
    }

    public Date getIsupdate() {
        return isupdate;
    }

    public void setIsupdate(Date isupdate) {
        this.isupdate = isupdate;
    }

    public String getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic == null ? null : coverPic.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getFontNum() {
        return fontNum;
    }

    public void setFontNum(String fontNum) {
        this.fontNum = fontNum == null ? null : fontNum.trim();
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl == null ? null : bookUrl.trim();
    }

    public Integer getChapter() {
        return chapter;
    }

    public void setChapter(Integer chapter) {
        this.chapter = chapter;
    }
}