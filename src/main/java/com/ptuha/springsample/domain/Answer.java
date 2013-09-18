package com.ptuha.springsample.domain;

import javax.persistence.*;
import java.io.Serializable;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

@NamedQueries(
        {
                @NamedQuery(name = "get answer", query = "from Answer where id = :id"),
                @NamedQuery(name = "get all answers", query = "from Answer where question_id = :id"),
                @NamedQuery(name = "delete answer", query = "delete from Answer where id = :id")
        }
)
@Entity
@Table(name = "Answers")
public class Answer implements Serializable {
    private int id;
    private String text;
    private DateTime postingDate;
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

    @NotEmpty
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    @Column(name = "date")
    public DateTime getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(DateTime postingDate) {
        this.postingDate = postingDate;
    }

    @Column(name = "likes")
    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
