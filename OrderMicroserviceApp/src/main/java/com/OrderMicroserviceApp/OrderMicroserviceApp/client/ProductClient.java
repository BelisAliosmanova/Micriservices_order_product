package com.OrderMicroserviceApp.OrderMicroserviceApp.client;

import com.OrderMicroserviceApp.OrderMicroserviceApp.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "orderProduct-app")
public interface ProductClient {
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id")Long id);
}
