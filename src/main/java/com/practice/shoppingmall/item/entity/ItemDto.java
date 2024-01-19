package com.practice.shoppingmall.item.entity;

import com.practice.shoppingmall.common.status.ItemSellStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ItemDto {

    private Long itemId;

    private String name;

    private int price;

    private int stockNumber; //재고수량

    private String itemDetails; //상세 설명

    private ItemSellStatus itemSellStatus;

}
