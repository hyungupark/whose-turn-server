package com.hyungu.whoseturn.repositories;

import com.hyungu.whoseturn.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, String> {

    List<Member> findAllMembers();

}
