package com.example.bai_hat.service.impl;

import com.example.bai_hat.model.Song;
import com.example.bai_hat.repository.ISongRepository;
import com.example.bai_hat.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository songRepository;

    @Override
    public Page<Song> getAll(Pageable pageable) {
        return songRepository.getAllByFlagDeleteIsFalse(pageable);
    }

    @Override
    public void addNewSong(Song song) {
        song.setFlagDelete(false);
        songRepository.save(song);
    }

    @Override
    public Song getById(Integer id) {
        return songRepository.getSongByIdAndFlagDeleteIsFalse(id);
    }

    @Override
    public void updateSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public void deleteSong(Integer id) {
        Song song = songRepository.getSongByIdAndFlagDeleteIsFalse(id);
        song.setFlagDelete(true);
        songRepository.save(song);
    }
}
