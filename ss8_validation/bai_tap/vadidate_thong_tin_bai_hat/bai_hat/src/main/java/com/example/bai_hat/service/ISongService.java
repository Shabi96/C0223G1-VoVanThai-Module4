package com.example.bai_hat.service;

import com.example.bai_hat.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongService {
    Page<Song> getAll(Pageable pageable);
    void addNewSong(Song song);

    Song getById(Integer id);

    void updateSong(Song song);

    void deleteSong(Integer id);
}
