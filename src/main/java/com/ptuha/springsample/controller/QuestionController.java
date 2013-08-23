package com.ptuha.springsample.controller;

import com.ptuha.springsample.domain.Answer;
import com.ptuha.springsample.domain.Question;
import com.ptuha.springsample.service.AnswerService;
import com.ptuha.springsample.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@SessionAttributes({"question", "answer"})
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homeHandler(Model model) {
        model.addAttribute("questions", questionService.getAllQuestions());
        return "home";
    }

    @RequestMapping(value = "/questions/ask", method = RequestMethod.GET)
    public String askQuestionForm(Model model) {
        model.addAttribute("question", new Question());
        return "questionAdd";
    }

    @RequestMapping(value = "/questions/get/{questionId}", method = RequestMethod.GET)
    public String getQuestion(@PathVariable("questionId") int questionId, Model model) {
        Question question = questionService.getQuestion(questionId);
        Answer answer = new Answer();
        model.addAttribute("question", question);
        model.addAttribute("answer", answer);
        return "questionGet";
    }

    @RequestMapping(value = "/questions/add", method = RequestMethod.POST)
    public String addQuestion(@ModelAttribute("question") @Valid Question question, BindingResult result) {
        if(result.hasErrors()) {
            return "questionAdd";
        }

        questionService.saveQuestion(question);
        return "redirect:/home";
    }

    @RequestMapping(value = "/questions/delete/{questionId}", method = RequestMethod.GET)
    public @ResponseBody String deleteQuestion(@PathVariable("questionId") int questionId) {
        questionService.deleteQuestion(questionId);
        return String.valueOf(questionId);
    }

    @RequestMapping(value = "/questions/like", method = RequestMethod.GET)
    public @ResponseBody String likeQuestion(@RequestParam("questionId") int questionId) {
        String likes = questionService.likeQuestion(questionId);
        return likes;
    }

    @RequestMapping(value = "/questions/dislike", method = RequestMethod.GET)
    public @ResponseBody String dislikeQuestion(@RequestParam("questionId") int questionId) {
        String likes = questionService.dislikeQuestion(questionId);
        return likes;
    }
}
