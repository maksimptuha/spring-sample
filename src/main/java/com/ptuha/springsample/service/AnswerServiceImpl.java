package com.ptuha.springsample.service;

import com.ptuha.springsample.dao.AnswerDAO;
import com.ptuha.springsample.domain.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("answerService")
@Transactional(readOnly = true)
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerDAO answerDAO;

    public Answer getAnswer(int answerId) {
        return answerDAO.getAnswer(answerId);
    }

    public List<Answer> getAllAnswers(int questionId) {
        return answerDAO.getAllAnswers(questionId);
    }

    @Transactional
    public void saveAnswer(Answer answerForSaving) {
        if (answerForSaving.getPostingDate() == null) {
            answerForSaving.setPostingDate(new Date());
        }
        answerDAO.saveAnswer(answerForSaving);
    }

    @Transactional
    public void deleteAnswer(int answerForRemovingId) {
        answerDAO.deleteAnswer(answerForRemovingId);
    }

    @Transactional
    public String likeAnswer(int answerId) {
        Answer answer = this.getAnswer(answerId);
        answer.setLikes(answer.getLikes() + 1);
        this.saveAnswer(answer);
        return String.valueOf(answer.getLikes());
    }

    @Transactional
    public String dislikeAnswer(int answerId) {
        Answer answer = this.getAnswer(answerId);
        answer.setLikes(answer.getLikes() - 1);
        this.saveAnswer(answer);
        return String.valueOf(answer.getLikes());
    }
}
