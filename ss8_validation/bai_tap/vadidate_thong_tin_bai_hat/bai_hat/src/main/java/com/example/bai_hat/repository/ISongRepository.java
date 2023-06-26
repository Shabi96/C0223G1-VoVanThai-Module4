package com.example.bai_hat.repository;

import com.example.bai_hat.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ISongRepository extends JpaRepository<Song, Integer> {
    Page<Song> getAllByFlagDeleteIsFalse(Pageable pageable);

    Song getSongByIdAndFlagDeleteIsFalse(Integer id);

}
