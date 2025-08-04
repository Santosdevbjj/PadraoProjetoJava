package strategy;

import org.springframework.stereotype.Component;

@Component("pixPayment")
public class PixPayment implements PaymentStrategy {
    @Override
    public String pay(double amount) {
        return "Pagamento de R$ " + amount + " via Pix.";
    }
}
