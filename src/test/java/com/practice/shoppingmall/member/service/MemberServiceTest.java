package com.practice.shoppingmall.member.service;

import com.practice.shoppingmall.member.entity.Member;
import com.practice.shoppingmall.member.entity.MemberFormDto;
import com.practice.shoppingmall.member.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class MemberServiceTest {
    @Autowired
    MemberRepository memberRepository;

    @PersistenceContext
    EntityManager em;

    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Member createMember(){
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setName("첫번째");
        memberFormDto.setEmail("test@naver.com");
        memberFormDto.setAddress("서울");
        memberFormDto.setPassword("1234");
        return Member.createMember(memberFormDto, passwordEncoder);
    }
    
    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemberTest(){
        Member member = createMember();
        Member saveMember = memberService.save(member);

        assertEquals(member.getMemberId(), saveMember.getMemberId());
    }
    
    @Test
    @DisplayName("중복 이메일 테스트")
    public void DuplicateMemberTest(){
        Member member1 = createMember();
        Member member2 = createMember();

        memberService.save(member1);

        Throwable e = assertThrows(IllegalStateException.class, () ->{
            memberService.save(member2);
        });

        assertEquals("이미 가입된 회원입니다." , e.getMessage());
    }

    @Test
    @DisplayName("Auditing 테스트")

    public void auditingTest(){
        Member newMember = new Member();
        memberRepository.save(newMember);

        em.flush();
        em.clear();

        Member member = memberRepository.findById(newMember.getMemberId())
                .orElseThrow(EntityNotFoundException::new);

        System.out.println("register time : " + member.getRegTime());
        System.out.println("update time : " + member.getUpdateTime());
        System.out.println("create member : " + member.getCreateBy());
        System.out.println("modify member : " + member.getModifiedBy());
    }



}