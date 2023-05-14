package com.OrderMicroserviceApp.OrderMicroserviceApp.repository;

import com.OrderMicroserviceApp.OrderMicroserviceApp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
