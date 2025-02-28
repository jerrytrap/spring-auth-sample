package org.example.springauthsample.member.repository;

import org.example.springauthsample.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> getMemberByUsername(String username);
}