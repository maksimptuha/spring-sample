package com.ptuha.springsample.service;

import com.ptuha.springsample.dao.QuestionDAO;
import com.ptuha.springsample.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("questionService")
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

    @Transactional
    public String likeQuestion(int questionId) {
        Question question = this.getQuestion(questionId);
        question.setLikes(question.getLikes() + 1);
        this.saveQuestion(question);
        return String.valueOf(question.getLikes());
    }

    @Transactional
    public String dislikeQuestion(int questionId) {
        Question question = this.getQuestion(questionId);
        question.setLikes(question.getLikes() - 1);
        this.saveQuestion(question);
        return String.valueOf(question.getLikes());
    }
}
