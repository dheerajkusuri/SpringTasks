package com.jwt.jwtAuthentication.controller;

import com.jwt.jwtAuthentication.Utils.JwtUtil;
import com.jwt.jwtAuthentication.model.JwtResponse;
import com.jwt.jwtAuthentication.model.ModelClass;
import com.jwt.jwtAuthentication.model.TokenValidation;
import com.jwt.jwtAuthentication.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JwtController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    String token;
    UserDetails userDetails;
    @RequestMapping(value="/token",method= RequestMethod.POST)
    public ResponseEntity<?>generateToken(@RequestBody ModelClass modelClass) throws Exception {
        System.out.println(modelClass);
        try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(modelClass.getUsername(),modelClass.getPassword()));
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new Exception("Bad credentials");
        }

        userDetails= this.customUserDetailsService.loadUserByUsername(modelClass.getUsername());
        token = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT : "+token);
        return ResponseEntity.ok(new JwtResponse(token));
    }
    @RequestMapping(value="/token",method= RequestMethod.GET)
    public ResponseEntity<?>checkToken(@RequestBody TokenValidation tokenValidation) throws Exception {
        System.out.println(tokenValidation);
        String invalid;
        String expired;
        String valid;
        expired = String.valueOf(jwtUtil.isTokenExpired(token));
        valid = String.valueOf(jwtUtil.validateToken(token,userDetails));
        invalid = String.valueOf(!jwtUtil.validateToken(token,userDetails));
        //String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("Expired : "+expired);
        System.out.println("Valid : "+valid);
        System.out.println("Invalid : "+invalid);
        return ResponseEntity.ok(new TokenValidation(expired,valid,invalid));
    }
}
