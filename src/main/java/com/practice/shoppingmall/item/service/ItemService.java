package com.practice.shoppingmall.item.service;


import com.practice.shoppingmall.item.entity.Item;
import com.practice.shoppingmall.item.entity.ItemFormDto;
import com.practice.shoppingmall.item.entity.ItemImg;
import com.practice.shoppingmall.item.entity.ItemImgDto;
import com.practice.shoppingmall.item.repository.ItemImgRepository;
import com.practice.shoppingmall.item.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    @Autowired
    private final ItemImgRepository itemImgRepository;
    @Autowired
    private final ItemRepository itemRepository;
    @Autowired
    private final ItemImgService itemImgService;

    public Long saveItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws Exception{

        //상품 등록
        Item item = itemFormDto.createItem();
        itemRepository.save(item);

        //이미지등록
        for(int i =0; i < itemImgFileList.size(); i++){
            ItemImg itemImg = new ItemImg();
            itemImg.setItem(item);
            if(i==0)
                itemImg.setRpImgYn("Y");
            else
                itemImg.setRpImgYn("N");
            itemImgService.saveItemImg(itemImg, itemImgFileList.get(i));
        }

        return item.getItemId();

    }
}
