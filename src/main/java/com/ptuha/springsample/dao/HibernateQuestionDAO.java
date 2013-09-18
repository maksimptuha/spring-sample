package com.ptuha.springsample.dao;

import com.ptuha.springsample.domain.Question;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateQuestionDAO implements QuestionDAO {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Question getQuestion(int questionId) {
        Query query = getSession().getNamedQuery("get question");
        query.setInteger("id", questionId);
        return (Question) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Question> getAllQuestions() {
        Query query = getSession().getNamedQuery("get all questions");
        return query.list();
    }

    public void saveQuestion(Question questionForSaving) {
        getSession().saveOrUpdate(questionForSaving);
        getSession().flush();
    }

    public void deleteQuestion(int questionForRemovingId) {
        Query query = getSession().getNamedQuery("delete question");
        query.setInteger("id", questionForRemovingId);
        query.executeUpdate();
    }
}
