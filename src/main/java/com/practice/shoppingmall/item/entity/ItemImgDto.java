package com.practice.shoppingmall.item.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class ItemImgDto {
    // modelMapper  서로 다른 class( imgItem, imgItemDto ) 의 필드가 서로 같다면
    // getter, setter를 통해 값을 복사해서 객체를 반환

    private Long itemImgId;


    private String imgName; //이미지 파일명

    private String oriImgName; //원본 이미지 파일명

    private String imgUrl; //이미지 조회 경로

    private String rpImgYn; //대표이미지 여부

    private static ModelMapper modelMapper = new ModelMapper();


    public static ItemImgDto of(ItemImg itemImg){
        return modelMapper.map(itemImg, ItemImgDto.class);
    }

}
