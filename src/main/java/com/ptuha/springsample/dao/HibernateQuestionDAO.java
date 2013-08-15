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

    public Question getQuestion(int questionId) {
        Query query = sessionFactory.getCurrentSession().createQuery("Question.get");
        query.setInteger("id", questionId);
        return (Question) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Question> getAllQuestions() {
        Query query = sessionFactory.getCurrentSession().createQuery("Question.getAll");
        return query.list();
    }

    public void saveQuestion(Question questionForSaving) {
        sessionFactory.getCurrentSession().save(questionForSaving);
    }

    public void deleteQuestion(int questionForRemovingId) {
        Query query = sessionFactory.getCurrentSession().createQuery("Question.delete");
        query.setInteger("id", questionForRemovingId);
        query.executeUpdate();
    }
}
