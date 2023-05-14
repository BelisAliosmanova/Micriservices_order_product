package com.OrderMicroserviceApp.OrderMicroserviceApp.controller;

import com.OrderMicroserviceApp.OrderMicroserviceApp.dto.OrderDTO;
import com.OrderMicroserviceApp.OrderMicroserviceApp.model.Order;
import com.OrderMicroserviceApp.OrderMicroserviceApp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orderDTOS = orderService.getAllOrders();
        var status = orderDTOS.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return ResponseEntity.status(status).body(orderDTOS);
    }

    @PostMapping("/add")
    public ResponseEntity<Order> addOrder(@RequestBody Order order, UriComponentsBuilder uriComponentsBuilder) {
        URI location = uriComponentsBuilder.path("/orders/{id}").buildAndExpand(orderService.addOrder(order, uriComponentsBuilder).getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/getOrder/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<Order> deleteOrderById(@PathVariable("id") Long id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateOrder{id}")
    public ResponseEntity<String> updateOrder(@PathVariable("orderId") Long orderId,
                                              @RequestBody OrderDTO orderDTO) {
        boolean updated = orderService.updateOrder(orderId, orderDTO);
        if (updated) {
            return ResponseEntity.ok("Order updated!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update the order");
        }
    }
}
