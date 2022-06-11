package com.example.coffeshopexam.service;

import com.example.coffeshopexam.model.service.OrderServiceModel;
import com.example.coffeshopexam.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel map);

    List<OrderViewModel> findAllOrdersOrderedByPriceDesc();

    void readyOrder(Long id);

}
