package com.practice.shoppingmall.member.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDto {

    private String name;

    private String email;

    private String password;

    private String address;
}
