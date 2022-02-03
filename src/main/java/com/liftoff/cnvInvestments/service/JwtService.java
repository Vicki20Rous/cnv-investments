package com.liftoff.cnvInvestments.service;

import com.liftoff.cnvInvestments.dao.UserDao;
import com.liftoff.cnvInvestments.entity.JwtRequest;
import com.liftoff.cnvInvestments.entity.JwtResponse;
import com.liftoff.cnvInvestments.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) {
        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public void authenticate(String userName, String userPassword) {
        try {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
    } catch ()
}
