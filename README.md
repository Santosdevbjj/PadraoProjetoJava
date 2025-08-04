## Bootcamp TONNIE - Java and AI in Europe, ministrado pela DIO.

![TonnieJava](https://github.com/user-attachments/assets/7fbcaae1-c7e0-4c3c-84a0-e7051de1a640)

**Design Patterns com Java: Dos Clássicos (GoF) ao Spring Framework.**


**DESCRIÇÃO:**
Agora é a sua hora de brilhar! Explore o conceito de Padrões de Projeto na prática, implementando soluções que utilizem os padrões clássicos do GoF e as abstrações fornecidas pelo Spring Framework. 

Você pode reproduzir um dos projetos criados durante as aulas ou desenvolver uma nova ideia do zero. 

Esteja pronto para mostrar suas habilidades de design e programação, e não se esqueça de compartilhar seu projeto em seu repositório Git!

---

**Design Patterns com Java e Spring Boot**

✅ **Descrição do Projeto**

Este repositório demonstra a aplicação de Padrões de Projeto (Design Patterns) utilizando:

# 1. Java Puro

Padrões: Singleton, Strategy, Facade



# 2. Spring Boot

Padrões: Singleton, Strategy, Facade em uma API REST



O objetivo é mostrar a implementação prática desses padrões, tanto manualmente quanto aproveitando os recursos do Spring Framework.


---

✅ **Padrões Utilizados**

**Singleton**

**Java Puro:** Implementado manualmente na classe ConfigManager.

**Spring Boot:** Implementado de forma nativa, pois os beans Spring são Singletons por padrão.


**Strategy**

Define uma família de algoritmos, encapsula cada um e os torna intercambiáveis.

**Implementações:**

**Java Puro:** CreditCardPayment e PixPayment implementando PaymentStrategy.

**Spring Boot:** Estratégias registradas como @Component e injetadas dinamicamente via Spring.



**Facade**

Fornece uma interface simplificada para interagir com subsistemas complexos.

**Implementação:**

**Java Puro:** OrderFacade simplifica o uso das estratégias.

**Spring Boot:** OrderFacade organiza a lógica de processamento via API REST.



---

✅ **Estrutura dos Projetos**

# 1. Projeto com Java Puro

<img width="1080" height="1054" alt="Screenshot_20250804-020950" src="https://github.com/user-attachments/assets/67dbe7fb-116f-41b7-9eb2-52705dd9a315" />


**Classes**

**ConfigManager (Singleton):** Garante uma única instância para configurações globais.

**PaymentStrategy (Interface):** Define contrato para métodos de pagamento.

**CreditCardPayment / PixPayment:** Implementam diferentes estratégias de pagamento.

**PaymentContext:** Permite definir e executar uma estratégia.

**OrderFacade:** Simplifica a execução de pedidos, delegando à estratégia apropriada.

**Main:** Demonstra o uso dos padrões.



---

# 2. Projeto com Spring Boot

<img width="838" height="917" alt="Screenshot_20250804-022456" src="https://github.com/user-attachments/assets/e04d222a-ee0a-43b9-a032-2aaeedb7f0f5" />


             
**Classes**

**DesignPatternsApplication:** Classe principal do Spring Boot.

**AppConfig (Singleton):** Exemplo de Bean Singleton (@Configuration).

**PaymentStrategy (Interface):** Contrato para pagamentos.

**CreditCardPayment / PixPayment:** Estratégias registradas com @Component.

**PaymentService:** Injeção de estratégias via Map<String, PaymentStrategy>.

**OrderFacade:** Interface simples para processar pedidos.

**PaymentController:** Expõe API REST para escolher estratégias via requisição.



---

✅ **Como Rodar os Projetos**

# Java Puro

**1. Compile:**

javac Main.java


**2. Execute:**

java Main



# Spring Boot

**1. Vá até a pasta spring-design-patterns.**


**2. Execute:**

mvn spring-boot:run


**3. API disponível em:**

http://localhost:8080




---

✅ **Testando a API (Spring Boot)**

**Pagamento via Cartão**

**POST** http://localhost:8080/payments/creditCardPayment/100

**Resposta:**

Pedido processado com sucesso: Pagamento de R$ 100.0 via Cartão de Crédito.

**Pagamento via Pix**

**POST** http://localhost:8080/payments/pixPayment/250

**Resposta:**

Pedido processado com sucesso: Pagamento de R$ 250.0 via Pix.


---

✅ **Diagrama UML dos Padrões**

classDiagram
    class PaymentStrategy {
        <<interface>>
        + pay(amount: double): String
    }

    class CreditCardPayment {
        + pay(amount: double): String
    }

    class PixPayment {
        + pay(amount: double): String
    }

    class PaymentService {
        - Map<String, PaymentStrategy> strategies
        + processPayment(type: String, amount: double): String
    }

    class OrderFacade {
        - paymentService: PaymentService
        + processOrder(type: String, amount: double): String
    }

    class PaymentController {
        - orderFacade: OrderFacade
        + pay(type: String, amount: double): String
    }

    PaymentStrategy <|.. CreditCardPayment
    PaymentStrategy <|.. PixPayment
    PaymentService --> PaymentStrategy
    OrderFacade --> PaymentService
    PaymentController --> OrderFacade


---

✅ **Próximos Passos**

Adicionar novos métodos de pagamento.

Implementar Boleto, PayPal como novas estratégias.

Criar testes automatizados com JUnit.

Adicionar Dockerfile e docker-compose.yml para rodar com contêiner.



---






