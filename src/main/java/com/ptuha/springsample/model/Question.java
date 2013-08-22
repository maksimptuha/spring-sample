package com.ptuha.springsample.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
//import org.hibernate.validator.constraints.NotEmpty;
//import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Questions")
public class Question implements Serializable {
    private int id;
    private String title;
    private String text;
    private Date postingDate;
    private int likes;
    private List<Answer> answers;

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
    //@Length(max = 100)
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "question")
    @OrderBy("likes desc")
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
