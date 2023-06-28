package com.example.ung_dung_muon_sach.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer code;
    private LocalDateTime borrowDate;
    @ManyToOne
    private Book book;
    private boolean flagDelete;

    public Borrow() {
    }

    public Borrow(Integer id, Integer code, LocalDateTime borrowDate, Book book, boolean flagDelete) {
        this.id = id;
        this.code = code;
        this.borrowDate = borrowDate;
        this.book = book;
        this.flagDelete = flagDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
