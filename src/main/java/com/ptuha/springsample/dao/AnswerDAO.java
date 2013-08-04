package com.ptuha.springsample.dao;

import com.ptuha.springsample.model.Answer;

import java.util.List;

public interface AnswerDAO {
    Answer getAnswer(long answerId);
    List<Answer> getAllAnswers(long questionId);
    void saveAnswer(Answer answerForSaving);
    void deleteAnswer(long answerForRemovingId);
}
