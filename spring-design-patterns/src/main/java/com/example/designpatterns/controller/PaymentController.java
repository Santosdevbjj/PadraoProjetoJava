package com.example.designpatterns.controller;

import com.example.designpatterns.facade.OrderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private OrderFacade orderFacade;

    @PostMapping("/{type}/{amount}")
    public String pay(@PathVariable String type, @PathVariable double amount) {
        return orderFacade.processOrder(type, amount);
    }
}
