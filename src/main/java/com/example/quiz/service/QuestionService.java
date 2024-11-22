package com.example.quiz.service;

import com.example.quiz.model.Question;
import com.example.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getRandomQuestion() {
        List<Question> allQuestions = questionRepository.findAll();
        return allQuestions.get(new Random().nextInt(allQuestions.size()));
    }

    public void addQuestion(Question question) {
        questionRepository.save(question);
    }
}