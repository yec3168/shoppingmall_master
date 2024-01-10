package com.practice.shoppingmall.item.repository;

import com.practice.shoppingmall.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    List<Item> findByItemName(String itemName);

    List<Item> findByItemNameOrItemDetails(String itemName, String itemDetails);

    @Query("SELECT i from Item i where i.itemDetails like %:itemDetails% order by  i.itemPrice desc ")
    List<Item> findByItemDetails(@Param("itemDetails") String itemDetials);
}
