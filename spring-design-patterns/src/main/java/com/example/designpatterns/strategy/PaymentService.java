package strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentService {
    @Autowired
    private Map<String, PaymentStrategy> strategies;

    public String processPayment(String type, double amount) {
        PaymentStrategy strategy = strategies.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("Estratégia não encontrada: " + type);
        }
        return strategy.pay(amount);
    }
}
