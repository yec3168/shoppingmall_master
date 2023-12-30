package com.practice.shoppingmall.item.service;


import com.practice.shoppingmall.item.entity.ItemDto;
import com.practice.shoppingmall.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor //생성자 자동 생성.
public class ItemServiceImpl implements ItemService{

    @Autowired
    private final ItemRepository itemRepository;

    // 상품 등록 하는 메서드 (상품 명은 따로 중복 o)
    @Override
    public void register(ItemDto itemDto) {
        itemRepository.save(itemDto.toEntity());
    }
}
