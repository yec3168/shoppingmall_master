package com.practice.shoppingmall.item.repository;

import com.practice.shoppingmall.item.entity.ItemImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemImgRepository extends JpaRepository<ItemImg, Long> {

}
