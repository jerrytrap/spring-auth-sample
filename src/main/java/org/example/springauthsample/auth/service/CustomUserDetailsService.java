package org.example.springauthsample.auth.service;

import lombok.RequiredArgsConstructor;
import org.example.springauthsample.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.getMemberByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}