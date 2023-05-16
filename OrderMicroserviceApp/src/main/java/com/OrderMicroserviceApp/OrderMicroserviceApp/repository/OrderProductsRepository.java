package com.OrderMicroserviceApp.OrderMicroserviceApp.repository;

import com.OrderMicroserviceApp.OrderMicroserviceApp.model.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductsRepository extends JpaRepository<OrderProducts, Long> {
}
