package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.Borrow;

import java.util.List;


public interface IBorrowService {
    String addNewBorrow(Book book);

    List<Borrow> getAll();

    void deleteBorrowBook(Integer id);

    Borrow findById(Integer id);

    Borrow findByIdAndFlagIsTrue(Integer id);

    boolean findByCode(Integer code);

    Borrow getByCode(Integer code);
}
