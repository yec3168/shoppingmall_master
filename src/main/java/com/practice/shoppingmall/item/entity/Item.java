package com.practice.item.entity;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    // 상품 등록 시간

    // 상품 수정 시간(?)
}

