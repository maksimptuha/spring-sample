package com.ptuha.springsample.service;

import com.ptuha.springsample.dao.QuestionDAO;
import com.ptuha.springsample.domain.Question;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class QuestionServiceImpl implements QuestionService {
    private static final Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);

    @Autowired
    private QuestionDAO questionDAO;

    public Question getQuestion(int questionId) {
        logger.info("Requested question with id " + questionId);

        return questionDAO.getQuestion(questionId);
    }

    public List<Question> getAllQuestions() {
        logger.info("Requested all questions");

        return questionDAO.getAllQuestions();
    }

    @Transactional
    public void saveQuestion(Question questionForSaving) {
        logger.info("Saved question");

        questionForSaving.setText(questionForSaving.getText().replace("\n", "<br/>"));

        if(questionForSaving.getPostingDate() == null) {
            questionForSaving.setPostingDate(new DateTime());
        }
        questionDAO.saveQuestion(questionForSaving);
    }

    @Transactional
    public void deleteQuestion(int questionForRemovingId) {
        logger.info("Removed question with id " + questionForRemovingId);

        questionDAO.deleteQuestion(questionForRemovingId);
    }

    @Transactional
    public String likeQuestion(int questionId) {
        logger.info("Liked question with id " + questionId);

        Question question = this.getQuestion(questionId);
        question.setLikes(question.getLikes() + 1);
        this.saveQuestion(question);
        return String.valueOf(question.getLikes());
    }

    @Transactional
    public String dislikeQuestion(int questionId) {
        logger.info("Disliked question with id " + questionId);

        Question question = this.getQuestion(questionId);
        question.setLikes(question.getLikes() - 1);
        this.saveQuestion(question);
        return String.valueOf(question.getLikes());
    }
}
