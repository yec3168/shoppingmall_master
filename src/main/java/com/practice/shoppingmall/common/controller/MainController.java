package com.practice.shoppingmall.common.controller;

import org.springframework.ui.Model;
import com.practice.shoppingmall.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final ItemService itemService;

    //Mainhomepage layout구성
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("itemList", itemService.findAllList());
        return "layout/mainlayout";
    }
}
