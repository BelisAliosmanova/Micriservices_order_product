package com.OrderMicroserviceApp.OrderMicroserviceApp.service;

import com.OrderMicroserviceApp.OrderMicroserviceApp.dto.OrderDTO;
import com.OrderMicroserviceApp.OrderMicroserviceApp.model.Order;
import com.OrderMicroserviceApp.OrderMicroserviceApp.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public List<OrderDTO> getAllOrders() {
        List<Order> orderDTOS = orderRepository.findAll();
        return orderDTOS.stream().map(orders -> modelMapper.map(orders, OrderDTO.class)).collect(Collectors.toList());
    }

    public Order addOrder(Order order, UriComponentsBuilder uriComponentsBuilder) {
        return orderRepository.save(order);
    }

    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(RuntimeException::new);
        return modelMapper.map(order, (Type) OrderDTO.class);
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

    public boolean updateOrder(Long orderId, OrderDTO orderDTO) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order existingOrder = optionalOrder.get();
            existingOrder.setOrderDateTime(orderDTO.getOrderDateTime());
            existingOrder.setCustomerName(orderDTO.getCustomerName());
            existingOrder.setProduct(orderDTO.getProduct());
            orderRepository.save(existingOrder);
            return true;
        }
        return false;
    }
}