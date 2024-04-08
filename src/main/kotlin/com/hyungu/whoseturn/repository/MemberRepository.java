package com.hyungu.whoseturn.repository;

import com.hyungu.whoseturn.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
