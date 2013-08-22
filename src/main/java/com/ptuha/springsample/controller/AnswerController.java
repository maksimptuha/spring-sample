package com.ptuha.springsample.controller;

import com.ptuha.springsample.model.Answer;
import com.ptuha.springsample.model.Question;
import com.ptuha.springsample.service.AnswerService;
import com.ptuha.springsample.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnswerController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;

    @RequestMapping(value = "/answers/add", method = RequestMethod.POST)
    public String addAnswer(@ModelAttribute("answer") Answer answer, @RequestParam("questionId") int questionId) {
        Question question = questionService.getQuestion(questionId);
        question.getAnswers().add(answer);
        answer.setQuestion(question);
        answerService.saveAnswer(answer);
        return "redirect:/questions/get/" + answer.getQuestion().getId();
    }

    @RequestMapping(value = "/answers/delete/{questionId}/{answerId}", method = RequestMethod.GET)
    public String deleteAnswer(@PathVariable("questionId") int questionId, @PathVariable("answerId") int answerId) {
        answerService.deleteAnswer(answerId);
        return "redirect:/questions/get/" + questionId;
    }

    @RequestMapping(value = "/answers/like", method = RequestMethod.GET)
    public @ResponseBody String likeAnswer(@RequestParam("answerId") int answerId) {
        String likes = answerService.likeAnswer(answerId);
        return likes;
    }

    @RequestMapping(value = "/answers/dislike", method = RequestMethod.GET)
    public @ResponseBody String dislikeAnswer(@RequestParam("answerId") int answerId) {
        String likes = answerService.dislikeAnswer(answerId);
        return likes;
    }
}
