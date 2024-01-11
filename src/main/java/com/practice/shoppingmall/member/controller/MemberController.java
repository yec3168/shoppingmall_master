package com.practice.shoppingmall.member.controller;

import com.practice.shoppingmall.member.entity.MemberFormDto;
import com.practice.shoppingmall.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private MemberService memberService;

    public String memberForm(Model model){
        model.addAttribute("memberFromDto", new MemberFormDto());
        return "member/memberForm";
    }
}
