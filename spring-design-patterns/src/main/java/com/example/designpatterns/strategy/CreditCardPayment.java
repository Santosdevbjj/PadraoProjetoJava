package com.example.designpatterns.strategy;

import org.springframework.stereotype.Component;

@Component("creditCardPayment")
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public String pay(double amount) {
        return "Pagamento de R$ " + amount + " via Cartão de Crédito.";
    }
}
