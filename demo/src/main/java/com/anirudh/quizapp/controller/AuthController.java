package com.anirudh.quizapp.controller;

import com.anirudh.quizapp.model.JwtRequest;
import com.anirudh.quizapp.model.JwtResponse;
import com.anirudh.quizapp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody JwtRequest jwtRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        jwtRequest.getEmail(),
                        jwtRequest.getPassword()
                )
        );

        // ✅ Get UserDetails safely
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // ✅ Generate token using userDetails
        String token = jwtUtil.generateToken(userDetails.getUsername());

        return new JwtResponse(token);
    }
}
