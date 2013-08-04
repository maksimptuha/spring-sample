package com.ptuha.springsample.dao;

import com.ptuha.springsample.model.Answer;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateAnswerDAO implements AnswerDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Answer getAnswer(long answerId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Answers where id = :id");
        query.setLong("id", answerId);
        return (Answer) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Answer> getAllAnswers(long questionId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Answers where question_id = :id");
        query.setLong("id", questionId);
        return query.list();
    }

    public void saveAnswer(Answer answerForSaving) {
        sessionFactory.getCurrentSession().save(answerForSaving);
    }

    public void deleteAnswer(long answerForRemovingId) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from Answers where id = :id");
        query.setLong("id", answerForRemovingId);
        query.executeUpdate();
    }
}
