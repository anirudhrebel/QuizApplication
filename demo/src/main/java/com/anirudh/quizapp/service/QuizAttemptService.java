package com.anirudh.quizapp.service;



import com.anirudh.quizapp.model.QuizAttempt;
import com.anirudh.quizapp.repository.QuizAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizAttemptService {

    @Autowired
    private QuizAttemptRepository quizAttemptRepository;

    // Save a quiz attempt
    public QuizAttempt saveQuizAttempt(QuizAttempt quizAttempt) {
        return quizAttemptRepository.save(quizAttempt);
    }

    // Get all quiz attempts
    public List<QuizAttempt> getAllQuizAttempts() {
        return quizAttemptRepository.findAll();
    }

    // Get attempts by user ID
    public List<QuizAttempt> getQuizAttemptsByUserId(Long userId) {
        return quizAttemptRepository.findByUserId(userId);
    }
}
