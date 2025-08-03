import facade.OrderFacade;
import singleton.ConfigManager;
import strategy.CreditCardPayment;
import strategy.PixPayment;

public class Main {
    public static void main(String[] args) {
        // Singleton
        System.out.println("App: " + ConfigManager.getInstance().getAppName());

        // Facade + Strategy
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.processOrder(100.0, new CreditCardPayment());
        orderFacade.processOrder(250.0, new PixPayment());
    }
}
