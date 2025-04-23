package com.anirudh.quizapp.service;



import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Primary
public class CustomUserDetailsService implements UserDetailsService {

    // Temporary in-memory logic for testing JWT
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("anirudh".equals(username)) {
            return new User("anirudh", "{noop}anipass", new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}
