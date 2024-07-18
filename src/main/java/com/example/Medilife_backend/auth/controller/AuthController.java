package com.example.Medilife_backend.auth.controller;

import com.example.Medilife_backend.auth.dto.AuthRequest;
import com.example.Medilife_backend.auth.entity.JwtResponse;
import com.example.Medilife_backend.auth.entity.UserCredential;
import com.example.Medilife_backend.auth.repository.UserCredentialRepo;
import com.example.Medilife_backend.auth.service.AuthService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medilife")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserCredentialRepo userCredentialRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostConstruct
    public void initRoleAndUser() {
        authService.initRoleAndUser();
    }

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential userCredential){
        return authService.saveUser(userCredential);
    }

    @PostMapping("/token")
    public JwtResponse getToken(@RequestBody AuthRequest authRequest){
        Authentication authenticate =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getUserPassword()));
        if(authenticate.isAuthenticated()){
        return authService.generateToken(authRequest.getUserName());
        }
        else {
           throw new RuntimeException("invalid access");
        }

    }


    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
        authService.validateToken(token);
        return "Token is valid";
    }

    @GetMapping("/forUser")
    public UserCredential userDetail(@RequestParam String userName){

        return userCredentialRepo.findById(userName).get();
    }




}
