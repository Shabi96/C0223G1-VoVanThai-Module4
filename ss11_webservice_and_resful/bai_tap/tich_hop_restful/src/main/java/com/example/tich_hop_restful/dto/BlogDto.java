package com.example.tich_hop_restful.dto;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

public class BlogDto {
    private Integer id;
    @Pattern(regexp = "^[\\w ,]+$", message = "Name field can't not empty!!!!")
    private String name;
    @Pattern(regexp = "^[\\w ,]+$", message = "Name field can't not empty!!!!")
    private String content;
    private LocalDateTime dateTime;
    private boolean flagDelete;

    public BlogDto() {
    }

    public BlogDto(Integer id, String name, String content, LocalDateTime dateTime, boolean flagDelete) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.dateTime = dateTime;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
