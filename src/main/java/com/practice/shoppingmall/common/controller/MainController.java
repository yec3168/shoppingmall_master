package com.practice.shoppingmall.common.controller;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MainController {

    //Mainhomepage layout구성
    @GetMapping("/")
    public String home(Model model){

        return "layout/mainlayout";
    }
}
