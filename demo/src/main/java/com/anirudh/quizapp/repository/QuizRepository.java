package com.anirudh.quizapp.repository;



import com.anirudh.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    // You can add custom query methods here if needed
}
