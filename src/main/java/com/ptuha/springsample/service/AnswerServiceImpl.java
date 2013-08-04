package com.ptuha.springsample.service;

import com.ptuha.springsample.dao.AnswerDAO;
import com.ptuha.springsample.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerDAO answerDAO;

    public Answer getAnswer(long answerId) {
        return answerDAO.getAnswer(answerId);
    }

    public List<Answer> getAllAnswers(long questionId) {
        return answerDAO.getAllAnswers(questionId);
    }

    @Transactional
    public void saveAnswer(Answer answerForSaving) {
        answerDAO.saveAnswer(answerForSaving);
    }

    @Transactional
    public void deleteAnswer(long answerForRemovingId) {
        answerDAO.deleteAnswer(answerForRemovingId);
    }
}
