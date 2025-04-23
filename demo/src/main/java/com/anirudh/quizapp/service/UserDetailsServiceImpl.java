package com.anirudh.quizapp.service;

import com.anirudh.quizapp.model.QuizAppUser;  // Updated import
import com.anirudh.quizapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User; // Spring Security's User class
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch the custom user from the database (now QuizAppUser)
        QuizAppUser user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Return UserDetails using Spring Security's User.builder
        return User.builder()
                .username(user.getEmail())  // Email as username
                .password(user.getPassword())  // Password
                .roles(user.getRole())  // Role (e.g., ADMIN, USER)
                .build();
    }
}
