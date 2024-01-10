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

    @ManyToOne  //하나의 상품에는 여러 이미지가 존재.
    @JoinColumn(name = "item_id")
    private Item itemId;

    // 이미지 바꿀시, 해당 메서드를 호출(이름, 원본이름, 경로 수정)
    public void updateImg(String imgName, String originFileName, String imgUrl){
        this.imgName = imgName;
        this.originFileName = originFileName;
        this.imgUrl = imgUrl;
    }
}
