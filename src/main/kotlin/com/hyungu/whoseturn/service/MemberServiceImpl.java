package com.hyungu.whoseturn.service;

import com.hyungu.whoseturn.model.Member;
import com.hyungu.whoseturn.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
    }

    @Override
    public Member updateMember(Member member, Long id) {
        Member existingMember = getMemberById(id);
        existingMember.setId(member.getId());
        existingMember.setName(member.getName());
        return memberRepository.save(existingMember);
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

}
