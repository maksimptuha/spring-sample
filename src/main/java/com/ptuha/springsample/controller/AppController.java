package com.ptuha.springsample.controller;

import com.ptuha.springsample.model.Answer;
import com.ptuha.springsample.model.Question;
import com.ptuha.springsample.service.AnswerService;
import com.ptuha.springsample.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;

    @RequestMapping(value = {"/", "/home"})
    public String homeHandler(Model model) {
        model.addAttribute("questions", questionService.getAllQuestions());
        return "home";
    }

    @RequestMapping("/questions/ask")
    public String askQuestionForm(Model model) {
        Question question = new Question();
        model.addAttribute("question", question);
        return "questionAdd";
    }

    @RequestMapping("/questions/get/{questionId}")
    public String getQuestion(@PathVariable("questionId") int questionId, Model model) {
        Question question = questionService.getQuestion(questionId);
        Answer answer = new Answer();
        answer.setQuestion(question);
        model.addAttribute("answer", answer);
        model.addAttribute("question", question);
        return "questionShow";
    }

    @RequestMapping(value = "/questions/add", method = RequestMethod.POST)
    public String addQuestion(@ModelAttribute("question") Question question) {
        questionService.saveQuestion(question);
        return "redirect:/home";
    }

    @RequestMapping(value = "/answers/add", method = RequestMethod.POST)
    public String addAnswer(@ModelAttribute("answer") Answer answer) {
        answerService.saveAnswer(answer);
        return "redirect:/questions/get/" + answer.getQuestion().getId();
    }
}
