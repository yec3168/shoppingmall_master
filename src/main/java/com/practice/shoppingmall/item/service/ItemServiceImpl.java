package com.practice.item.service;

import com.practice.item.entity.Item;
import com.practice.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor //생성자 자동 생성.
public class ItemServiceImpl implements ItemService{

    @Autowired
    private final ItemRepository itemRepository;

    // 상품 등록하는 메서드
    @Override
    public String register(Item item) {



        itemRepository.save(item);
        return null;
    }
}
