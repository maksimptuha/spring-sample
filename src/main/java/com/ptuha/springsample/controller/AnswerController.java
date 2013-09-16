package com.ptuha.springsample.controller;

import com.ptuha.springsample.domain.Answer;
import com.ptuha.springsample.domain.Question;
import com.ptuha.springsample.service.AnswerService;
import com.ptuha.springsample.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Iterator;

@Controller
public class AnswerController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;

    @RequestMapping(value = "/answers/add", method = {RequestMethod.GET, RequestMethod.POST})
    public String addAnswer(@ModelAttribute("answer") @Valid Answer answer, BindingResult result,
                            @RequestParam("questionId") int questionId, SessionStatus status) {
        if(result.hasErrors()) {
            return "questionGet";
        }

        Question question = questionService.getQuestion(questionId);
        question.getAnswers().add(answer);
        answer.setQuestion(question);
        answerService.saveAnswer(answer);
        status.setComplete();
        return "redirect:/questions/get/" + answer.getQuestion().getId();
    }

    @RequestMapping(value = "/answers/delete/{answerId}", method = RequestMethod.GET)
    public @ResponseBody String deleteAnswer(@PathVariable("answerId") int answerId, HttpSession session) {
        Question question = (Question) session.getAttribute("question");
        Iterator<Answer> iterator = question.getAnswers().iterator();
        while (iterator.hasNext()) {
            Answer answer = iterator.next();
            if(answer.getId() == answerId) {
                iterator.remove();
            }
        }

        answerService.deleteAnswer(answerId);
        return String.valueOf(answerId);
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
