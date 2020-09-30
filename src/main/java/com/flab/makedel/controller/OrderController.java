package com.flab.makedel.controller;

import com.flab.makedel.annotation.CurrentUserId;
import com.flab.makedel.annotation.LoginCheck;
import com.flab.makedel.annotation.LoginCheck.UserLevel;
import com.flab.makedel.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stores/{storeId}/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @LoginCheck(userLevel = UserLevel.USER)
    public void registerOrder(@CurrentUserId String userId, @PathVariable long storeId) {
        orderService.registerOrder(userId, storeId);
    }
}
