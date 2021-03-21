package com.sheke.walking.controller;


import com.sheke.walking.dtos.LoginDto;
import com.sheke.walking.utils.JwtUtilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@Order(6)
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtilities jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;


    @ResponseStatus(OK)
    @PostMapping("/login")
    public String login (@RequestBody LoginDto dto) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("incorrect username or passoword!");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return jwt;
    }
}
