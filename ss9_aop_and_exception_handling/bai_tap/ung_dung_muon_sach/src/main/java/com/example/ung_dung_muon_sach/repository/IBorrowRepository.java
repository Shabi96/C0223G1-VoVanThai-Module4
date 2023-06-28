package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBorrowRepository extends JpaRepository<Borrow, Integer> {
    List<Borrow> getAllByFlagDeleteIsFalse();

    Borrow findBorrowByIdAndFlagDeleteIsFalse(Integer id);

    Borrow findBorrowByIdAndFlagDeleteIsTrue(Integer id);

    boolean existsByCodeAndFlagDeleteIsFalse(Integer code);

    boolean existsByCode(Integer code);

    Borrow getBorrowByCodeAndFlagDeleteIsFalse(Integer code);

}
