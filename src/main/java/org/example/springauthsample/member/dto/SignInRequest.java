package org.example.springauthsample.member.dto;

import lombok.Getter;

@Getter
public class SignInRequest {
    private String username;
    private String password;
}