package com.example.tich_hop_restful.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(columnDefinition = "long")
    private String content;
    @Column(name = "create_date")
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Category category;
    @Column(name = "is_delete")
    @JsonIgnore
    private boolean flagDelete;

    public Blog() {
    }

    public Blog(Integer id, String name, String content, LocalDateTime date, Category category, boolean flagDelete) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.date = date;
        this.category = category;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
