package com.ptuha.springsample.service;

import com.ptuha.springsample.model.Answer;
import com.ptuha.springsample.model.Question;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring-config.xml");
        context.refresh();
        QuestionService questionService = context.getBean("questionService", QuestionService.class);
        AnswerService answerService = context.getBean("answerService", AnswerService.class);
    }
}
