package com.anirudh.quizapp.service;

import com.anirudh.quizapp.model.Option;
import com.anirudh.quizapp.model.Question;
import com.anirudh.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    // Save a question (with options if needed)
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    // Get all questions
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    // Get questions by quiz ID
    public List<Question> getQuestionsByQuizId(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }

    // Delete question by ID
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
