package com.hyungu.whoseturn;

import com.hyungu.whoseturn.entities.Member;
import com.hyungu.whoseturn.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Member member = memberRepository.findById(Long.valueOf(id)).orElse(null);
        if (member == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.builder()
                .username(member.getName())
                .build();
    }

}
