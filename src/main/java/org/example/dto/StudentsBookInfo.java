package org.example.dto;

import java.time.LocalDateTime;

public class StudentsBookInfo {
    private Integer id;
    private String bookTitle;
    private String BookAuthor;
    private LocalDateTime createdDate;
    public StudentsBookInfo() {
    }
    public StudentsBookInfo(Integer id, String bookTitle, String bookAuthor, LocalDateTime createdDate) {
        this.id = id;
        this.bookTitle = bookTitle;
        BookAuthor = bookAuthor;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return BookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        BookAuthor = bookAuthor;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "StudentsBookInfo{" +
                "orderNumber=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                ", BookAuthor='" + BookAuthor + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
