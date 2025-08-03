package strategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Pagamento de R$ " + amount + " via Cartão de Crédito.");
    }
}
