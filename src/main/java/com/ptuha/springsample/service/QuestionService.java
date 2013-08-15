package com.ptuha.springsample.service;

import com.ptuha.springsample.model.Question;

import java.util.List;

public interface QuestionService {
    Question getQuestion(int questionId);
    List<Question> getAllQuestions();
    void saveQuestion(Question questionForSaving);
    void deleteQuestion(int questionForRemovingId);
}
