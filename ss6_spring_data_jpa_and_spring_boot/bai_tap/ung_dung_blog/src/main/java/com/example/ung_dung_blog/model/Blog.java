package com.example.ung_dung_blog.model;

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
    @Column(columnDefinition = "long")
    private String img;
    @ManyToOne
    @JoinColumn(nullable = false, name = "blog_type_id")
    private Category category;
    @Column(name = "is_delete")
    private boolean flagDelete;

    public Blog() {
    }

    public Blog(Integer id, String name, String content, LocalDateTime date, String img, Category category, boolean flagDelete) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.date = date;
        this.img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
