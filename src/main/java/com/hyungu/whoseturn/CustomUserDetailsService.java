package com.hyungu.whoseturn;

import com.hyungu.whoseturn.entities.Member;
import com.hyungu.whoseturn.repositories.MemberRepository;
import com.hyungu.whoseturn.services.MemberService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberService memberService;

    public CustomUserDetailsService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Member member = memberService.getMemberById(Long.valueOf(id)).orElseThrow();
        return new CustomUserDetails(member);
    }

}
