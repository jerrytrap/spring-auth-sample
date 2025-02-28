package org.example.springauthsample.member.service;

import lombok.RequiredArgsConstructor;
import org.example.springauthsample.member.entity.Member;
import org.example.springauthsample.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Member getMember(String username) {
        return memberRepository.getMemberByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}