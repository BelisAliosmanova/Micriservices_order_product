package com.OrderMicroserviceApp.OrderMicroserviceApp.service;

import com.OrderMicroserviceApp.OrderMicroserviceApp.dto.OrderDTO;
import com.OrderMicroserviceApp.OrderMicroserviceApp.model.Order;
import com.OrderMicroserviceApp.OrderMicroserviceApp.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
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
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(order -> modelMapper.map(order, OrderDTO.class)).collect(Collectors.toList());
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(RuntimeException::new);
        return modelMapper.map(order, (Type) OrderDTO.class);
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

    public OrderDTO updateOrder(Long id, Order order) throws ChangeSetPersister.NotFoundException {
        Order orderUpdate = orderRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        orderUpdate.setId(order.getId());
        orderUpdate.setOrderDateTime(order.getOrderDateTime());
        orderUpdate.setCustomerName(order.getCustomerName());
        orderRepository.save(orderUpdate);
        return modelMapper.map(orderUpdate, OrderDTO.class);
    }
}