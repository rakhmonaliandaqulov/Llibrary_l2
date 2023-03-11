package org.example.dto;

import java.time.LocalDate;

public class Book {
    private Integer id;
    private String title;
    private String author;
    private LocalDate publishYear;
    private Integer amount;
    public Book() {
    }

    public Book(Integer id, String title, String author, LocalDate publishYear, Integer amount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.amount = amount;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public LocalDate getPublishYear() {
        return publishYear;
    }
    public void setPublishYear(LocalDate publishYear) {
        this.publishYear = publishYear;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                ", amount=" + amount +
                '}';
    }
}
