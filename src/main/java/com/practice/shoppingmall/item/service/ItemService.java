package com.practice.item.service;

import com.practice.item.entity.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public interface ItemService {

    String register(Item item);
}
