package com.example.bai_hat.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class SongDto {
    private Integer id;
    @Pattern(regexp = "^[\\w ]+$", message = "Name can't empty, max is 800 character and can't contain specials character!!!!")
    @Size(max = 800)
    private String name;
    @Pattern(regexp = "^[\\w ]+$", message = "Artist can't empty, max is 300 character and can't contain specials character!!!!")
    @Size(max = 300)
    private String artist;
    @Pattern(regexp = "^[\\w ,]+$", message = "Kind Of Music can't empty and max is 1000 character and can't contain specials character!!!!")
    @Size(max = 1000)
    private String kindOfMusic;
    private boolean flagDelete;

    public SongDto() {
    }

    public SongDto(Integer id, String name, String artist, String kindOfMusic, boolean flagDelete) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
        this.flagDelete = flagDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
