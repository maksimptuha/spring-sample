package com.ptuha.springsample.dao;

import com.ptuha.springsample.model.Question;

import java.util.List;

public interface QuestionDAO {
    Question getQuestion(String questionTitle);
    List<Question> getAllQuestions();
    void saveQuestion(Question questionForSaving);
    void deleteQuestion(long questionForRemovingId);
}
