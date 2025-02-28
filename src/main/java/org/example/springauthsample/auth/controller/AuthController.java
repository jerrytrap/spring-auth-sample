package org.example.springauthsample.auth.controller;

import lombok.RequiredArgsConstructor;
import org.example.springauthsample.global.web.CookieUtil;
import org.example.springauthsample.member.dto.SignInRequest;
import org.example.springauthsample.member.dto.SignInResponse;
import org.example.springauthsample.auth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    private final CookieUtil cookieUtil;

    @PostMapping("/sign-in")
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest request) {
        SignInResponse signInResponse = authService.signIn(request);
        cookieUtil.addCookie("access-token", signInResponse.getAccessToken());

        return ResponseEntity.ok(signInResponse);
    }

    @PostMapping("/sign-out")
    public ResponseEntity<Void> signOut() {
        cookieUtil.deleteCookie("access-token");
        return ResponseEntity.noContent().build();
    }
}