package com.example.ung_dung_muon_sach.service.impl;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.repository.IBookRepository;
import com.example.ung_dung_muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void updateBook(Book book) {
        book.setAmount(book.getAmount() - 1);
        bookRepository.save(book);
    }

    @Override
    public void giveBook(Book book) {
        book.setAmount(book.getAmount() + 1);
        bookRepository.save(book);
    }
}
