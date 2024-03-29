package com.practice.shoppingmall.item.entity;


import com.practice.shoppingmall.common.entity.BaseEntity;
import com.practice.shoppingmall.common.status.ItemSellStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="item")
@Entity
@Getter
@Setter
public class Item extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int stockNumber; //재고수량

    @Lob //가변 길이를 갖는 큰 데이터를 저장.
    @Column(length = 200)
    private String itemDetails; //상세 설명

    //상품 판매 상태
    @Enumerated(EnumType.STRING) // 반환시 String으로 반환.
    private ItemSellStatus itemSellStatus;



}

