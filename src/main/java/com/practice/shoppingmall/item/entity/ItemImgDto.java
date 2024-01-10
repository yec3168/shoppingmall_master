package com.practice.shoppingmall.item.entity;

import lombok.Data;

@Data
public class ItemImgDto {

    private Long itemImgId;

    private String imgName; //저장시 이미지 이름

    private String originFileName;  // 원본 이미지 이름

    private String imgUrl; // 이미지 조회 경로

    private String defaultImg; // defaultImg


    public ItemImg toEntity(){
        return ItemImg.builder()
                .imgName(imgName)
                .originFileName(originFileName)
                .imgUrl(imgUrl)
                .defaultImg(defaultImg)
                .build();
    }

}
