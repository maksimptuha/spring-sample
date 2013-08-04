package com.ptuha.springsample.dao;

import com.ptuha.springsample.model.Question;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateQuestionDAO implements QuestionDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Question getQuestion(String questionTitle) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Questions where title = :title");
        query.setString("title", questionTitle);
        return (Question) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Question> getAllQuestions() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Questions");
        return query.list();
    }

    public void saveQuestion(Question questionForSaving) {
        sessionFactory.getCurrentSession().save(questionForSaving);
    }

    public void deleteQuestion(long questionForRemovingId) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from Questions where id = :id");
        query.setLong("id", questionForRemovingId);
        query.executeUpdate();
    }
}
