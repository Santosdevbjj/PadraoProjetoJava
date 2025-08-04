package facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import strategy.PaymentService;

@Component
public class OrderFacade {
    @Autowired
    private PaymentService paymentService;

    public String processOrder(String type, double amount) {
        return "Pedido processado: " + paymentService.processPayment(type, amount);
    }
}
