package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    private String Date;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Message(){}

    public Message(@NotEmpty String title, @NotEmpty String content, @NotEmpty String writtenBy, String date, User user) {
        this.title = title;
        this.content = content;
        Date = date;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
