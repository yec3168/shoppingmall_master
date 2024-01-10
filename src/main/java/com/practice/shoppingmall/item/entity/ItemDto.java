package com.practice.shoppingmall.item.entity;

import com.practice.shoppingmall.common.status.ItemSellStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ItemDto {

    private Long itemId;

    @NotBlank(message = "상품명은 필수 입력 값입니다.")
    private String itemName;

    @NotBlank(message = "가격은 필수 입력 값입니다.")
    private int itemPrice;

    @NotBlank(message = "재고수량은 필수 입력 값입니다.")
    private int stockNumber; //재고수량

    private String itemDetails; //상세 설명

    private String sellStatcd;

    private LocalDateTime regTime;

    private LocalDateTime updateTime;

    // toEntity로 레포지토리 dto를 통해 등록
    public Item toEntity(){
        return Item.builder()
                .itemId(itemId)
                .itemName(itemName)
                .itemPrice(itemPrice)
                .stockNumber(stockNumber)
                .itemDetails(itemDetails)
                .itemSellStatus(ItemSellStatus.SELL) //등록할땐 판매상태로 등록.
                .localDateTime(LocalDateTime.now())
                .build();
    }
}
