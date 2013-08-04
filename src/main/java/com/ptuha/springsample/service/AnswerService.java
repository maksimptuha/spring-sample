package com.ptuha.springsample.service;

import com.ptuha.springsample.model.Answer;

import java.util.List;

public interface AnswerService {
    Answer getAnswer(long answerId);
    List<Answer> getAllAnswers(long questionId);
    void saveAnswer(Answer answerForSaving);
    void deleteAnswer(long answerForRemovingId);
}
