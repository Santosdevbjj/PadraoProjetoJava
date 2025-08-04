package com.example.designpatterns.facade;

import com.example.designpatterns.strategy.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderFacade {
    @Autowired
    private PaymentService paymentService;

    public String processOrder(String type, double amount) {
        return "Pedido processado com sucesso: " + paymentService.processPayment(type, amount);
    }
}
