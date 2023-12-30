package com.practice.shoppingmall.item.entity;

import lombok.Data;

@Data
public class ItemDto {

    private String itemName;
    private int itemPrice;
    private int stockNumber; //재고수량
    private String itemDetails; //상세 설명

    
    // toEntity로 레포지토리 dto를 통해 등록
    public Item toEntity(){
        return Item.builder()
                .itemName(itemName)
                .itemPrice(itemPrice)
                .stockNumber(stockNumber)
                .itemDetails(itemDetails)
                .build();
    }
}
