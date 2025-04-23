package com.anirudh.quizapp.repository;


import com.anirudh.quizapp.model.QuizAppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<QuizAppUser, Long> {
    Optional<QuizAppUser> findByEmail(String email);
}
