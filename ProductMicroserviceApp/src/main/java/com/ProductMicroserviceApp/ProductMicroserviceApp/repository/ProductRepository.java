package com.ProductMicroserviceApp.ProductMicroserviceApp.repository;

import com.ProductMicroserviceApp.ProductMicroserviceApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
