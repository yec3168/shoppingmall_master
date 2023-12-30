package com.practice.shoppingmall.item.controller;

import com.practice.shoppingmall.item.entity.ItemDto;
import com.practice.shoppingmall.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/admin")
@Controller
public class ItemController {

    @Autowired
    private final ItemService itemService;

    // 상품 등록 페이지 load
    @GetMapping("/item/new")
    public String adminItemNewGet(){
        return "item/itemform";
    }

    // 상품 등록 페이지 post
    @PostMapping("/item/new")
    public String adminItemNewPost(ItemDto itemDto, Model model) throws Exception{

        model.addAttribute("message", "상품이 등록되었습니다.");
        model.addAttribute("searchUrl", "/");

        itemService.register(itemDto);
        return "item/itemmsg";
    }


    @GetMapping("/items")
    public String adminItem(){
        return "item/itemview";
    }
}
