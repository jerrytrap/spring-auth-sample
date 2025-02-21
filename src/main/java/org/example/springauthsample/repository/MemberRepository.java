package org.example.springauthsample.repository;

import org.example.springauthsample.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member getMemberByUsername(String username);
}