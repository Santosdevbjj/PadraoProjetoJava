package facade;

import strategy.PaymentContext;
import strategy.PaymentStrategy;

public class OrderFacade {
    private final PaymentContext paymentContext = new PaymentContext();

    public void processOrder(double amount, PaymentStrategy strategy) {
        paymentContext.setStrategy(strategy);
        System.out.println("Processando pedido...");
        paymentContext.executePayment(amount);
        System.out.println("Pedido concluído!");
    }
}
