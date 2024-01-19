package com.practice.shoppingmall.item.entity;

import com.practice.shoppingmall.common.status.ItemSellStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ItemFormDto {
    private Long itemId;

    @NotBlank(message = "상품명은 필수 입력 값입니다.")
    private String name;

    @NotBlank(message = "가격은 필수 입력 값입니다.")
    private int price;

    @NotBlank(message = "재고수량은 필수 입력 값입니다.")
    private int stockNumber; //재고수량

    @NotEmpty(message = "상품설명은 필수 입력 값입니다.")
    private String itemDetails; //상세 설명

    private ItemSellStatus itemSellStatus;

    private List<ItemImgDto> itemImgDtoList = new ArrayList<>();

    private List<Long> itemImgIds = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

    public Item createItem(){
        return modelMapper.map(this, Item.class);
    }

    public static ItemFormDto of(Item item){
        return modelMapper.map(item,ItemFormDto.class);
    }


}
