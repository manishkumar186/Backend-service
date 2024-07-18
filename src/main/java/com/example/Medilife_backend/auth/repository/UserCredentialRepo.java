package com.example.Medilife_backend.auth.repository;


import com.example.Medilife_backend.auth.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialRepo extends JpaRepository<UserCredential,String> {


}
