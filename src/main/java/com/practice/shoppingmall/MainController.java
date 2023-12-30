package com.practice.shoppingmall;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    //Mainhomepage layout구성
    @GetMapping("/")
    public String home(){
        return "layout/mainlayout";
    }
}
