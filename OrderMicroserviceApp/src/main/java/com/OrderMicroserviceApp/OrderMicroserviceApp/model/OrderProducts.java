package com.OrderMicroserviceApp.OrderMicroserviceApp.model;

import com.OrderMicroserviceApp.OrderMicroserviceApp.config.ProductDTOConverter;
import com.OrderMicroserviceApp.OrderMicroserviceApp.dto.OrderDTO;
import com.OrderMicroserviceApp.OrderMicroserviceApp.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order_id;

    @Convert(converter = ProductDTOConverter.class)
    private ProductDTO product;
}
