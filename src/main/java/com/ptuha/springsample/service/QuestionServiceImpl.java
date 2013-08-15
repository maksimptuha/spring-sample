package com.ptuha.springsample.service;

import com.ptuha.springsample.dao.QuestionDAO;
import com.ptuha.springsample.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDAO questionDAO;

    public Question getQuestion(int questionId) {
        return questionDAO.getQuestion(questionId);
    }

    public List<Question> getAllQuestions() {
        return questionDAO.getAllQuestions();
    }

    @Transactional
    public void saveQuestion(Question questionForSaving) {
        if(questionForSaving.getPostingDate() == null) {
            questionForSaving.setPostingDate(new Date());
        }
        questionDAO.saveQuestion(questionForSaving);
    }

    @Transactional
    public void deleteQuestion(int questionForRemovingId) {
        questionDAO.deleteQuestion(questionForRemovingId);
    }
}
