package com.example.quiz.service;

import com.example.quiz.model.AnswerOption;
import com.example.quiz.model.Question;
import com.example.quiz.model.Score;
import com.example.quiz.model.User;
import com.example.quiz.repository.QuestionRepository;
import com.example.quiz.repository.ScoreRepository;
import com.example.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    public User registerUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);
    }

    public Score submitAnswer(Long userId, Long questionId, Long optionId, boolean isCorrect) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        AnswerOption option = question.getOptions().stream()
                .filter(o -> o.getId().equals(optionId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Option not found"));

        Score score = new Score();
        score.setUser(user);
        score.setQuestion(question);
        score.setOption(option);
        score.setIsCorrect(isCorrect);

        return scoreRepository.save(score);
    }
}