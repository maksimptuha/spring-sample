package com.ptuha.springsample.dao;

import com.ptuha.springsample.domain.Answer;

import java.util.List;

public interface AnswerDAO {
    Answer getAnswer(int answerId);
    List<Answer> getAllAnswers(int questionId);
    void saveAnswer(Answer answerForSaving);
    void deleteAnswer(int answerForRemovingId);
}
