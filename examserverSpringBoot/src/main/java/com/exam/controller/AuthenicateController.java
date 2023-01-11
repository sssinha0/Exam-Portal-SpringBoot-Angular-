package com.exam.controller;

import com.exam.config.JwtUtils;
import com.exam.entity.jwtauth.JwtRequest;
import com.exam.entity.jwtauth.JwtResponse;
import com.exam.entity.login.User;
import com.exam.service.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthenicateController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsImpl userDetails;
    @Autowired
    private JwtUtils jwtUtils;

    //generte token
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        try{
        authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("user not found");
        }

        UserDetails userDetails1= this.userDetails.loadUserByUsername(jwtRequest.getUsername());
        String token=this.jwtUtils.generateToken(userDetails1);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private  void authenticate(String userName,String password) throws  Exception{
    try {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
    }catch (DisabledException e){
        throw new Exception("User Disabled"+e.getMessage());
    }catch (Exception e){
        throw  new Exception("Invalid Credentils"+e.getMessage());
    }
    }

    //return the current user
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
        return ((User) this.userDetails.loadUserByUsername(principal.getName()));
    }
}
