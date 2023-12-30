package com.practice.shoppingmall.item.entity;

import com.practice.shoppingmall.common.status.ItemSellStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemDto {

    private String itemName;
    private int itemPrice;
    private int stockNumber; //재고수량
    private String itemDetails; //상세 설명
    private ItemSellStatus itemSellStatus; //상품 판매 상태.


    
    // toEntity로 레포지토리 dto를 통해 등록
    public Item toEntity(){
        return Item.builder()
                .itemName(itemName)
                .itemPrice(itemPrice)
                .stockNumber(stockNumber)
                .itemDetails(itemDetails)
                .itemSellStatus(ItemSellStatus.SELL) //등록할땐 판매상태로 등록.
                .localDateTime(LocalDateTime.now())
                .build();
    }
}
