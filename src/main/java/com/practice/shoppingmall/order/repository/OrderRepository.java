package com.practice.shoppingmall.order.repository;

import com.practice.shoppingmall.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
