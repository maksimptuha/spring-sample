package com.ptuha.springsample.service;

import com.ptuha.springsample.dao.AnswerDAO;
import com.ptuha.springsample.domain.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class AnswerServiceImpl implements AnswerService {
    private static final Logger logger = LoggerFactory.getLogger(AnswerServiceImpl.class);

    @Autowired
    private AnswerDAO answerDAO;

    public Answer getAnswer(int answerId) {
        logger.info("Requested answer with id " + answerId);

        return answerDAO.getAnswer(answerId);
    }

    public List<Answer> getAllAnswers(int questionId) {
        logger.info("Requested all answers of question with id " + questionId);

        return answerDAO.getAllAnswers(questionId);
    }

    @Transactional
    public void saveAnswer(Answer answerForSaving) {
        logger.info("Saved answer");

        answerForSaving.setText(answerForSaving.getText().replace("\n", "<br/>"));

        if (answerForSaving.getPostingDate() == null) {
            answerForSaving.setPostingDate(new Date());
        }
        answerDAO.saveAnswer(answerForSaving);
    }

    @Transactional
    public void deleteAnswer(int answerForRemovingId) {
        logger.info("Removed answer with id " + answerForRemovingId);

        answerDAO.deleteAnswer(answerForRemovingId);
    }

    @Transactional
    public String likeAnswer(int answerId) {
        logger.info("Liked answer with id " + answerId);

        Answer answer = this.getAnswer(answerId);
        answer.setLikes(answer.getLikes() + 1);
        this.saveAnswer(answer);
        return String.valueOf(answer.getLikes());
    }

    @Transactional
    public String dislikeAnswer(int answerId) {
        logger.info("Disliked answer with id " + answerId);

        Answer answer = this.getAnswer(answerId);
        answer.setLikes(answer.getLikes() - 1);
        this.saveAnswer(answer);
        return String.valueOf(answer.getLikes());
    }
}
