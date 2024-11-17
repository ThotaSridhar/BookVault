package com.sridhar.BookVault.service.impl;

import com.sridhar.BookVault.domain.Users;
import com.sridhar.BookVault.repository.UserRepository;
import com.sridhar.BookVault.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsService userDetailsService;

    private  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public String logging(Users user) {
        Users user1 = userRepository.findByUsername(user.getUsername());
        System.out.println("username is "+user1.getUsername()+" and password is "+user1.getPassword());

        Authentication authentication = authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken
                        (user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()){
            return "success";
        }
        System.out.println(authentication.toString());
        return "failure";
    }
}
