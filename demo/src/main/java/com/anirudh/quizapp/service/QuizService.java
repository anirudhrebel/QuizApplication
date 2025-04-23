package com.anirudh.quizapp.service;

import com.anirudh.quizapp.model.Quiz;
import com.anirudh.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    // Create a new quiz
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    // Get all quizzes
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    // Get a quiz by its ID
    public Quiz getQuizById(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        return quiz.orElse(null);
    }


    public Quiz updateQuiz(Long id, Quiz newQuizDetails) {
        Optional<Quiz> existingQuizOpt = quizRepository.findById(id);
        if (existingQuizOpt.isPresent()) {
            Quiz existingQuiz = existingQuizOpt.get();
            existingQuiz.setTitle(newQuizDetails.getTitle());
            // Add other fields to update...
            return quizRepository.save(existingQuiz);
        }
        return null; // Or throw an exception
    }

    // Delete a quiz by its ID
    public boolean deleteQuiz(Long id) {
        if (quizRepository.existsById(id)) {
            quizRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
