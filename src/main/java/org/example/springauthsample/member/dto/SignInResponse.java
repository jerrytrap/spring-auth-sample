package org.example.springauthsample.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class SignInResponse {
    private final String accessToken;
    @Builder.Default
    private final String tokenType = "Bearer";
    @Builder.Default
    private final String expiresIn = "3600";
}