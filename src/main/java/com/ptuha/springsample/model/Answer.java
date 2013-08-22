package com.ptuha.springsample.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
//import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Answers")
public class Answer implements Serializable {
    private int id;
    private String text;
    private Date postingDate;
    private int likes;
    private Question question;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //@NotEmpty
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //@NotEmpty
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    //@NotEmpty
    @Column(name = "likes")
    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
