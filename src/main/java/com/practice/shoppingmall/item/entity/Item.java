package com.practice.shoppingmall.item.entity;


import com.practice.shoppingmall.common.status.ItemSellStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @Column(length = 30, nullable = false)
    private String itemName;

    @Column(nullable = false)
    private int itemPrice;

    @Column(nullable = false)
    private int stockNumber; //재고수량

    @Column(length = 200)
    private String itemDetails; //상세 설명

    //상품 판매 상태
    @Enumerated(EnumType.STRING) // 반환시 String으로 반환.
    private ItemSellStatus itemSellStatus;

    // 상품 등록 시간
    private LocalDateTime localDateTime;

}

