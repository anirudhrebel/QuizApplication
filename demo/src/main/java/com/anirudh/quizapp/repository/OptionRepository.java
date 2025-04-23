package com.anirudh.quizapp.repository;


import com.anirudh.quizapp.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {

}
