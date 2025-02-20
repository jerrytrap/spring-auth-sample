package org.example.springauthsample;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member getMemberByUsername(String username);
}