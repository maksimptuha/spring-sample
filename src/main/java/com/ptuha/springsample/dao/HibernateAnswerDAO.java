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

    public Answer getAnswer(int answerId) {
        Query query = sessionFactory.getCurrentSession().createQuery("Answer.get");
        query.setInteger("id", answerId);
        return (Answer) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Answer> getAllAnswers(int questionId) {
        Query query = sessionFactory.getCurrentSession().createQuery("Answer.getAll");
        query.setInteger("id", questionId);
        return query.list();
    }

    public void saveAnswer(Answer answerForSaving) {
        sessionFactory.getCurrentSession().save(answerForSaving);
    }

    public void deleteAnswer(int answerForRemovingId) {
        Query query = sessionFactory.getCurrentSession().createQuery("Answer.delete");
        query.setInteger("id", answerForRemovingId);
        query.executeUpdate();
    }
}
