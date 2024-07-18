package com.example.Medilife_backend.auth.service;

import com.example.Medilife_backend.auth.entity.JwtResponse;
import com.example.Medilife_backend.auth.entity.UserCredential;
import com.example.Medilife_backend.auth.repository.UserCredentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepo userCredentialRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    public String saveUser(UserCredential credential){
        credential.setUserPassword(passwordEncoder.encode(credential.getUserPassword()));
        userCredentialRepo.save(credential);
        return "User added to the system";
    }

    public JwtResponse generateToken(String username){

        String token = jwtService.generateToken(username);
        Optional<UserCredential> user = userCredentialRepo.findById(username);

        return new JwtResponse(user,token);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }


    public void initRoleAndUser() {

        UserCredential adminUser = new UserCredential();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(passwordEncoder.encode("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserEmail("admin@gmail.com");
        adminUser.setUserContact("123456789");
        adminUser.setUserAddress("New Delhi");
        adminUser.setUserGender("Male");
        adminUser.setUserPincode("143001");

        userCredentialRepo.save(adminUser);
    }
}