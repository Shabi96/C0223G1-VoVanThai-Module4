package com.example.ung_dung_blog.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table()
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(columnDefinition = "long")
    private String content;
    @Column(name = "create_date")
    private LocalDateTime date;
    private String img;

    public Blog() {
    }

    public Blog(Integer id, String name, String content, LocalDateTime date, String img) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.date = date;
        this.img = img;
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
}
