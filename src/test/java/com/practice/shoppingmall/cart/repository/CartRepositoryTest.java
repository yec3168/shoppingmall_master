package com.practice.shoppingmall.cart.repository;

import com.practice.shoppingmall.cart.entity.Cart;
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

@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PersistenceContext
    EntityManager em;

    public Member createMember(){
        MemberFormDto memberFormDto =new MemberFormDto();
        memberFormDto.setEmail("1@11");
        memberFormDto.setName("test");
        memberFormDto.setPassword("123123123");
        memberFormDto.setAddress("123");
        return Member.createMember(memberFormDto, passwordEncoder);
    }
    
    @Test
    @DisplayName("cart 테스트")
    public void CartCreateTest(){
        Member member = this.createMember();
        memberRepository.save(member);

        Cart cart = new Cart();
        cart.setMember(member);

        cartRepository.save(cart);

        em.flush(); //트랜잭션이 끝날 때 호출하여 데이터베이스에 반영
        em.clear(); //엔티티가 없을 경우 데이터베이스를 조회한다.

        Cart saveCart = cartRepository.findById(cart.getCartId()).orElseThrow(EntityNotFoundException::new);

        assertEquals(saveCart.getMember().getMemberId(), member.getMemberId());
    }

}