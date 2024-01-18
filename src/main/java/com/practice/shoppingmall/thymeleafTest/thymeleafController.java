package com.practice.shoppingmall.thymeleafTest;

import com.practice.shoppingmall.item.entity.Item;
import com.practice.shoppingmall.item.entity.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/thymeleaf")
@Controller
public class thymeleafController {

    @GetMapping("/ex01")
    public String ex01(Model model){
        model.addAttribute("data", "ex01입니다.");
        return"example/ex01";
    }

    @GetMapping("/ex02")
    public String ex02(Model model){
        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetails("상품 상세 설명");
        itemDto.setName("테스트 상품 1");
        itemDto.setPrice(10000);

        model.addAttribute("itemDto", itemDto);
        return "example/ex02";
    }

    @GetMapping("/ex03")
    public String ex03(Model model){
        List<ItemDto> itemList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetails("상품 상세 설명" +i);
            itemDto.setName("테스트 상품"+i);
            itemDto.setPrice(10000+i*1000);

            itemList.add(itemDto);

        }
        model.addAttribute("itemList", itemList);
        return "example/ex03";
    }
    @GetMapping("/ex04")
    public String ex04(Model model){
        List<ItemDto> itemList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetails("상품 상세 설명" +i);
            itemDto.setName("테스트 상품"+i);
            itemDto.setPrice(10000+i*1000);

            itemList.add(itemDto);

        }
        model.addAttribute("itemList", itemList);
        return "example/ex04";
    }
    @GetMapping("/ex05")
    public String ex05(Model model){
        List<ItemDto> itemList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetails("상품 상세 설명" +i);
            itemDto.setName("테스트 상품"+i);
            itemDto.setPrice(10000+i*1000);

            itemList.add(itemDto);

        }
        model.addAttribute("itemList", itemList);
        return "example/ex05";
    }

    @GetMapping("/ex06")
    public String ex06(Model model){
        return "example/ex06";
    }
    @GetMapping("/ex07")
    public String ex07(String param1, String param2, Model model){
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
        return "example/ex07";
    }

    @GetMapping("/ex08")
    public String ex07(){
        return "example/ex08";
    }
}
