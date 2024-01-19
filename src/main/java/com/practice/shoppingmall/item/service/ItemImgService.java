package com.practice.shoppingmall.item.service;

import com.practice.shoppingmall.common.service.FileService;
import com.practice.shoppingmall.item.entity.ItemImg;
import com.practice.shoppingmall.item.repository.ItemImgRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemImgService {

    @Value("${itemImgLocation}")
    private String itemImgLocation;

    @Autowired
    private final ItemImgRepository itemImgRepository;

    @Autowired
    private final FileService fileService;


    public void saveItemImg(ItemImg itemImg, MultipartFile itemImgFile) throws Exception{
        String oriImgName = itemImgFile.getOriginalFilename();
        String imgName = "";
        String imgUrl ="";

        //파일 업로드
        if(!StringUtils.isEmpty(oriImgName)){
            imgName = fileService.uploadFile(itemImgLocation, oriImgName, itemImgFile.getBytes());
            imgUrl = "/images/item/"+imgName;
        }

        //상품이미지 저장
        itemImg.updateImg(oriImgName, imgName, imgUrl);
        itemImgRepository.save(itemImg);
    }
}
