package com.hyungu.whoseturn.repositories;

import com.hyungu.whoseturn.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
