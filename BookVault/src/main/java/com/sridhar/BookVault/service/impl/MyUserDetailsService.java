package com.sridhar.BookVault.service.impl;

import com.sridhar.BookVault.domain.Users;
import com.sridhar.BookVault.repository.UserRepository;
import com.sridhar.BookVault.service.impl.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if(user==null){
            System.out.println("user not found");
            return null;
        }
        return new MyUserDetails(user);
    }
}
