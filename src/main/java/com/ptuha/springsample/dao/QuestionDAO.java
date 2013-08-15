package com.ptuha.springsample.dao;

import com.ptuha.springsample.model.Question;

import java.util.List;

public interface QuestionDAO {
    Question getQuestion(int questionId);
    List<Question> getAllQuestions();
    void saveQuestion(Question questionForSaving);
    void deleteQuestion(int questionForRemovingId);
}
