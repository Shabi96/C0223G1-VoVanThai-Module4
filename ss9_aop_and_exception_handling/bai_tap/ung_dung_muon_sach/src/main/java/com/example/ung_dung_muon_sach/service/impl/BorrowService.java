package com.example.ung_dung_muon_sach.service.impl;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.Borrow;
import com.example.ung_dung_muon_sach.repository.IBorrowRepository;
import com.example.ung_dung_muon_sach.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    private IBorrowRepository borrowRepository;

    @Override
    public String addNewBorrow(Book book) {
        Borrow borrow = new Borrow();
        int code = (int) Math.floor((Math.random() + 1) * 10000);
        while (borrowRepository.existsByCode(code)) {
            code = (int) Math.floor((Math.random() + 1) * 10000);
        }
        borrow.setCode(code);
        borrow.setBorrowDate(LocalDateTime.now());
        borrow.setFlagDelete(false);
        borrow.setBook(book);
        borrowRepository.save(borrow);
        return "Borrow success fully!!!! Your borrow code is: " + borrow.getCode();
    }

    @Override
    public List<Borrow> getAll() {
        return borrowRepository.getAllByFlagDeleteIsFalse();
    }

    @Override
    public void deleteBorrowBook(Integer id) {
        Borrow borrow = borrowRepository.findBorrowByIdAndFlagDeleteIsFalse(id);
        borrow.setFlagDelete(true);
        borrowRepository.save(borrow);
    }

    @Override
    public Borrow findById(Integer id) {
        return borrowRepository.findBorrowByIdAndFlagDeleteIsFalse(id);
    }

    @Override
    public Borrow findByIdAndFlagIsTrue(Integer id) {
        return borrowRepository.findBorrowByIdAndFlagDeleteIsTrue(id);
    }

    @Override
    public boolean findByCode(Integer code) {
        return borrowRepository.existsByCodeAndFlagDeleteIsFalse(code);
    }

    @Override
    public Borrow getByCode(Integer code) {
        return borrowRepository.getBorrowByCodeAndFlagDeleteIsFalse(code);
    }
}
