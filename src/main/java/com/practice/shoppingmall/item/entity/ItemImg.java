package com.practice.shoppingmall.item.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class ItemImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemImgId;

    private String imgName; //저장시 이미지 이름

    private String originFileName;  // 원본 이미지 이름

    private String imgUrl; // 이미지 조회 경로

    private String defaultImg; // defaultImg

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item itemId;


}
