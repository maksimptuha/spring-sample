package com.ptuha.springsample.dao;

import com.ptuha.springsample.domain.Question;
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
        Query query = sessionFactory.getCurrentSession().createQuery("from Question where id = :id");
        query.setInteger("id", questionId);
        return (Question) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Question> getAllQuestions() {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from Question question order by question.postingDate desc");
        return query.list();
    }

    public void saveQuestion(Question questionForSaving) {
        sessionFactory.getCurrentSession().saveOrUpdate(questionForSaving);
        sessionFactory.getCurrentSession().flush();
    }

    public void deleteQuestion(int questionForRemovingId) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from Question where id = :id");
        query.setInteger("id", questionForRemovingId);
        query.executeUpdate();
    }
}
