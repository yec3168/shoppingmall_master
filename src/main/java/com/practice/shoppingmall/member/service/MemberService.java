package com.practice.shoppingmall.member.service;

import com.practice.shoppingmall.member.entity.Member;
import com.practice.shoppingmall.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional // 에러가 발생하면 변경된 데이터를 에러가 발생하기 전으로 돌려줌.
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public Member save(Member member){
        vaildateDuplicateMember(member);
        return memberRepository.save(member);
    }

    public void vaildateDuplicateMember(Member member){
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email);

        if(member != null){
            throw new UsernameNotFoundException(email);
        }
        // 유저 객체 생성.
        return User.builder()
                .username(member.getName())
                .password(member.getPassword())
                .roles(member.getRoleStatus().toString())
                .build();
    }
}
