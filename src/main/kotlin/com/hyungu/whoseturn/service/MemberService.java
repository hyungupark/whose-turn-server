package com.hyungu.whoseturn.service;

import com.hyungu.whoseturn.model.Member;

import java.util.List;

public interface MemberService {

    Member saveMember(Member member);

    List<Member> getAllMembers();

    Member getMemberById(Long id);

    Member updateMember(Member member, Long id);

    void deleteMember(Long id);

}
