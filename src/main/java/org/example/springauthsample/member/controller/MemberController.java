package org.example.springauthsample.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.springauthsample.member.dto.MemberInfoResponse;
import org.example.springauthsample.member.entity.Member;
import org.example.springauthsample.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/info")
    public ResponseEntity<MemberInfoResponse> info(Principal principal) {
        Member member = memberService.getMember(principal.getName());
        return ResponseEntity.ok(new MemberInfoResponse(member.getUsername()));
    }
}