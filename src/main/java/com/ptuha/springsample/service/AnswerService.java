package com.ptuha.springsample.service;

import com.ptuha.springsample.model.Answer;

import java.util.List;

public interface AnswerService {
    Answer getAnswer(int answerId);
    List<Answer> getAllAnswers(int questionId);
    void saveAnswer(Answer answerForSaving);
    void deleteAnswer(int answerForRemovingId);
    String likeAnswer(int answerId);
    String dislikeAnswer(int answerId);
}
