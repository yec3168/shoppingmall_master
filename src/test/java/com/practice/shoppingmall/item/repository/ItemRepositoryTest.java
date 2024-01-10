package com.practice.shoppingmall.item.repository;

import com.practice.shoppingmall.common.status.ItemSellStatus;
import com.practice.shoppingmall.item.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

// test 실행 단축 키 ctrl +shift + f10
@SpringBootTest
// 기존의 application.properties가 존재해도 아래 애노테이션을 통해
// 우선순위를 둘 수 있음.
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest(){
        for (int i = 0; i <10; i++){
            Item item = new Item();
            item.setItemName("테스트 상품" + i);
            item.setItemPrice(10000+i*1000);
            item.setItemDetails("상세설명"+i);
            item.setStockNumber(100);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setLocalDateTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());

            Item saveItem = itemRepository.save(item);
            //System.out.println(saveItem.toString());
        }

        // 실행되는 sql문.
        //Hibernate:
        //    insert
        //    into
        //        item
        //        (item_details, item_name, item_price, item_sell_status, local_date_time, stock_number, update_time, item_id)
        //    values
        //        (?, ?, ?, ?, ?, ?, ?, default)
    }

    @Test
    @DisplayName("상품 저장 테스트2")
    public void createItemTest2(){
        for (int i = 0; i <5; i++){
            Item item = new Item();
            item.setItemName("테스트 상품" + i);
            item.setItemPrice(10000+i*1000);
            item.setItemDetails("상세설명"+i);
            item.setStockNumber(100);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setLocalDateTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());

           itemRepository.save(item);

        }
        for (int i = 5; i <10; i++){
            Item item = new Item();
            item.setItemName("테스트 상품" + i);
            item.setItemPrice(10000+i*1000);
            item.setItemDetails("상세설명"+i);
            item.setStockNumber(0);
            item.setItemSellStatus(ItemSellStatus.SOLD_OUT);
            item.setLocalDateTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());

            itemRepository.save(item);

        }
    }

    @Test
    @DisplayName("상품 이름 검색 테스트")
    public void findItemTest(){
        this.createItemTest();
        List<Item> itemlist = itemRepository.findByItemName("테스트 상품0");
        for(Item item : itemlist){
            System.out.println(item.toString());
        }
    }


    @Test
    @DisplayName("상품 이름 or 상세설명 테스트")
    public void findItemNameOrItemDetailsTest(){
        this.createItemTest();
        List<Item> itemList = itemRepository.findByItemNameOrItemDetails("테스트 상품1", "상세설명3");
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("상세설명 테스트")
    public void findByItemDetailsTest(){
        this.createItemTest();
        List<Item> itemList = itemRepository.findByItemDetails("상세설명");
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }
}