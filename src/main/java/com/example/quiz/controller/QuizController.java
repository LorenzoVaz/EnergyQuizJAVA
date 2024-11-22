package com.example.quiz.controller;

import com.example.quiz.model.Question;
import com.example.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/random-question")
    public Question getRandomQuestion() {
        return questionService.getRandomQuestion();
    }
}