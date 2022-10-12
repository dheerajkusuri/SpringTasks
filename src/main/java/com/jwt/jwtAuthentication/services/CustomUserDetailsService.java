package com.jwt.jwtAuthentication.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         if(username.equals("KD2106")){
             return new User("KD2106","password",new ArrayList<>());
         }
         else{
             throw new UsernameNotFoundException("User was not registered / not found");
         }
    }
}
