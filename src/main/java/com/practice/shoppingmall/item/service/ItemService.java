package com.practice.shoppingmall.item.service;

import com.practice.shoppingmall.item.entity.Item;
import com.practice.shoppingmall.item.entity.ItemDto;

import java.util.List;


public interface ItemService {

    void register(ItemDto itemDto);

    Item itemView(Long itemid);

    List<Item> findAllList();
}
