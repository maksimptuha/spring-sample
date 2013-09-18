package com.ptuha.springsample.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import org.joda.time.DateTime;

@NamedQueries(
        {
                @NamedQuery(name = "get question", query = "from Question where id = :id"),
                @NamedQuery(name = "get all questions", query = "from Question question order by question.postingDate desc"),
                @NamedQuery(name = "delete question", query = "delete from Question where id = :id")
        }
)
@Entity
@Table(name = "Questions")
public class Question implements Serializable {
    private int id;
    private String title;
    private String text;
    private DateTime postingDate;
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

    @NotEmpty
    @Length(max = 100)
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "question")
    @OrderBy("likes desc")
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
