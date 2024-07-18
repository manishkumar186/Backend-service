package com.example.Medilife_backend.OrderHistory.repository;

import com.example.Medilife_backend.OrderHistory.entity.orderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface orderRepository extends JpaRepository<orderDetail,Integer> {
    List<orderDetail> findByUserName(String userName);
}
