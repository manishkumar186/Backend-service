package com.example.Medilife_backend.auth.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCredential {
    @Id
    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    private String userEmail;
    private String userContact;
    private String userPincode;
    private String userGender;
    private String userAddress;
}
