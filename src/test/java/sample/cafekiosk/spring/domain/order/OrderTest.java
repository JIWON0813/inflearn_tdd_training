package sample.cafekiosk.spring.domain.order;

import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductSellingType;
import sample.cafekiosk.spring.domain.product.ProductType;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class OrderTest {

    void calculateTotalPrice(){
        List<Product> products = List.of(
                createProduct("001", 1000),
                createProduct("002", 2000)
        );

        Order order = Order.create(products, LocalDateTime.now());

        assertThat(order.getTotalPrice()).isEqualTo(3000);
    }

    private Product createProduct(String number, int price){
        return Product.builder()
                .type(ProductType.HANDMADE)
                .productNumber(number)
                .sellingType(ProductSellingType.SELLING)
                .name("ame")
                .price(price)
                .build();
    }

    void init(){
        List<Product> products = List.of(
                createProduct("001", 1000),
                createProduct("002", 2000)
        );

        Order order = Order.create(products, LocalDateTime.now());

        assertThat(order.getOrderStatus()).isEqualByComparingTo(OrderStatus.INIT);
    }

    void registeredDateTime(){
        List<Product> products = List.of(
                createProduct("001", 1000),
                createProduct("002", 2000)
        );

        LocalDateTime registeredDateTime = LocalDateTime.now();
        Order order = Order.create(products, registeredDateTime);

        assertThat(order.getRegisteredDateTime()).isEqualTo(registeredDateTime);
    }
}