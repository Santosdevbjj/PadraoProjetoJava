## Bootcamp TONNIE - Java and AI in Europe, ministrado pela DIO.

![TonnieJava](https://github.com/user-attachments/assets/7fbcaae1-c7e0-4c3c-84a0-e7051de1a640)


**Design Patterns com Java: Dos Clássicos (GoF) ao Spring Framework.**



**DESCRIÇÃO:**
Agora é a sua hora de brilhar! Explore o conceito de Padrões de Projeto na prática, implementando soluções que utilizem os padrões clássicos do GoF e as abstrações fornecidas pelo Spring Framework. Você pode reproduzir um dos projetos criados durante as aulas ou desenvolver uma nova ideia do zero. Esteja pronto para mostrar suas habilidades de design e programação, e não se esqueça de compartilhar seu projeto em seu repositório Git!

---


Spring Design Patterns API

✅ Descrição do Projeto

Este projeto demonstra a implementação prática de Padrões de Projeto (Design Patterns) utilizando Spring Boot.
Os padrões abordados são:

Singleton (escopo padrão do Spring)

Strategy (seleção dinâmica de algoritmos de pagamento)

Facade (simplificação do fluxo de pedidos)


O objetivo é aplicar conceitos do GoF (Gang of Four) e mostrar como o Spring Framework facilita a implementação desses padrões em uma API REST.


---

✅ Padrões de Projeto Utilizados

Singleton

No Spring, o escopo padrão dos Beans é Singleton.

A classe AppConfig define um bean appName com escopo Singleton, garantindo que exista apenas uma instância em todo o ciclo de vida da aplicação.


Strategy

Permite alterar a lógica de pagamento dinamicamente sem modificar o código cliente.

Implementações:

CreditCardPayment → Pagamento via cartão

PixPayment → Pagamento via Pix


Gerenciado pelo Spring via @Component e injetado pelo PaymentService.


Facade

Classe OrderFacade expõe um método simples (processOrder) para processar pedidos.

Internamente delega a lógica para PaymentService e suas estratégias.



---

✅ Diagrama UML

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

✅ Tecnologias Utilizadas

Java 17+

Spring Boot 3.x

Maven

Spring Web

Spring Boot DevTools



---

✅ Estrutura do Projeto

spring-design-patterns/
 ├── pom.xml
 └── src/main/java/com/example/designpatterns/
       ├── DesignPatternsApplication.java
       ├── config/AppConfig.java
       ├── strategy/
       │     ├── PaymentStrategy.java
       │     ├── CreditCardPayment.java
       │     ├── PixPayment.java
       │     └── PaymentService.java
       ├── facade/OrderFacade.java
       └── controller/PaymentController.java


---

✅ Como Executar o Projeto

Pré-requisitos

Java 17+

Maven instalado


Passos para rodar

1. Clone o repositório:

git clone https://github.com/seu-usuario/spring-design-patterns.git


2. Entre na pasta do projeto:

cd spring-design-patterns


3. Execute o projeto:

mvn spring-boot:run


4. A API estará disponível em:

http://localhost:8080




---

✅ Endpoints Disponíveis

Pagamento via Cartão de Crédito

POST http://localhost:8080/payments/creditCardPayment/100

Resposta:

Pedido processado com sucesso: Pagamento de R$ 100.0 via Cartão de Crédito.


---

Pagamento via Pix

POST http://localhost:8080/payments/pixPayment/250

Resposta:

Pedido processado com sucesso: Pagamento de R$ 250.0 via Pix.


---

✅ Como Funciona

O cliente envia um POST com o tipo de pagamento e o valor.

O Controller chama a Facade, que delega ao PaymentService.

O PaymentService seleciona a estratégia apropriada (Strategy Pattern).

A aplicação retorna uma mensagem de sucesso.



---

✅ Próximos Passos

Adicionar novos métodos de pagamento (Boleto, PayPal, etc.).

Implementar testes automatizados com JUnit.

Adicionar autenticação com Spring Security.



---

📌 Gostaria que eu também gere o código de um docker-compose.yml para rodar este projeto em contêiner com suporte a hot reload? Ou prefere que eu crie agora um repositório GitHub simulado com toda a estrutura (código + README)?

