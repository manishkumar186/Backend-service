package com.example.Medilife_backend.OrderHistory.service;

import com.example.Medilife_backend.OrderHistory.entity.orderDetail;
import com.example.Medilife_backend.OrderHistory.repository.orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderService {

    @Autowired
    orderRepository orderRepository;

    public orderDetail createOrder(orderDetail orderDetail) {
        return orderRepository.save(orderDetail);
    }

    public List<orderDetail> allOrderDetail() {
        return orderRepository.findAll();
    }

    public List<orderDetail> getOrderDetailByUserName(String userName) {
        return orderRepository.findByUserName(userName);
    }
}
