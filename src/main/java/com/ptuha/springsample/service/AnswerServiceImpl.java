package com.ptuha.springsample.service;

import com.ptuha.springsample.dao.AnswerDAO;
import com.ptuha.springsample.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
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
}
