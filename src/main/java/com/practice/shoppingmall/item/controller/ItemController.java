package com.practice.shoppingmall.item.controller;

import com.practice.shoppingmall.item.entity.ItemDto;
import com.practice.shoppingmall.item.entity.ItemFormDto;
import com.practice.shoppingmall.item.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin")
@Controller
public class ItemController {

   @Autowired
    private final ItemService itemService;

    @GetMapping("/item/new")
    public String itemForm(Model model){
        model.addAttribute("itemFormDto", new ItemFormDto());
        return "item/itemform";
    }

    @PostMapping("/item/new")
    public String itemNew(@Valid ItemFormDto itemFormDto, BindingResult bindingResult,
                          Model model, @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList){

        if(bindingResult.hasErrors()){
            return "item/itemform";
        }

        //이미지가 없거나, 아이디가 null값이면
        if(itemImgFileList.get(0).isEmpty() && itemFormDto.getItemId() ==null){
            model.addAttribute("errorMessage", "첫번째 상품이미지는 필수 입력값입니다.");
            return "item/itemform";
        }

        try{
            itemService.saveItem(itemFormDto, itemImgFileList);
        }catch (Exception e){
            model.addAttribute("errorMessage", "상품등록 중 에러가 발생하였습니다.");
            return "item/itemform";
        }
        return "redirect:/";
    }

}
