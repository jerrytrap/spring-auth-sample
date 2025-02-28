package org.example.springauthsample.auth.service;

import lombok.RequiredArgsConstructor;
import org.example.springauthsample.member.entity.Member;
import org.example.springauthsample.global.security.JwtTokenProvider;
import org.example.springauthsample.member.dto.SignInRequest;
import org.example.springauthsample.member.dto.SignInResponse;
import org.example.springauthsample.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public SignInResponse signIn(SignInRequest signInRequest) {
        Member member = memberRepository.getMemberByUsername(signInRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordEncoder.matches(signInRequest.getPassword(), member.getPassword())) {
            throw new RuntimeException();
        }

        return SignInResponse.builder()
                .accessToken(jwtTokenProvider.generateToken(member))
                .build();
    }
}