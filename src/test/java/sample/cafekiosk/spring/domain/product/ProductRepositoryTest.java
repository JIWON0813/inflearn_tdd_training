package sample.cafekiosk.spring.domain.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
//@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findAllBySellingIn(){
        Product product = Product.builder()
                .productNumber("001")
                .type(ProductType.HANDMADE)
                .sellingType(ProductSellingType.SELLING)
                .name("ame")
                .price(4000)
                .build();

        Product product2 = Product.builder()
                .productNumber("002")
                .type(ProductType.BAKERY)
                .sellingType(ProductSellingType.SELLING)
                .name("ame")
                .price(4000)
                .build();

        Product product3 = Product.builder()
                .productNumber("003")
                .type(ProductType.BOTTLE)
                .sellingType(ProductSellingType.HOLD)
                .name("ame")
                .price(4000)
                .build();

        Product product4 = Product.builder()
                .productNumber("004")
                .type(ProductType.HANDMADE)
                .sellingType(ProductSellingType.STOP_SELLING)
                .name("ame")
                .price(4000)
                .build();

        productRepository.saveAll(List.of(product,product2,product3,product4));

        List<Product> products = productRepository.findAllBySellingTypeIn(List.of(ProductSellingType.SELLING, ProductSellingType.HOLD));

        assertThat(products).hasSize(3)
                .extracting("productNumber","name","sellingType")
                .containsExactlyInAnyOrder(
                  tuple("001", "ame", ProductSellingType.SELLING),
                        tuple("002", "ame", ProductSellingType.SELLING),
                        tuple("003", "ame", ProductSellingType.HOLD)
                );
    }

    @Test
    void findAllByProductNumberIn() {
        Product product = Product.builder()
                .productNumber("001")
                .type(ProductType.HANDMADE)
                .sellingType(ProductSellingType.SELLING)
                .name("ame")
                .price(4000)
                .build();

        Product product2 = Product.builder()
                .productNumber("002")
                .type(ProductType.BAKERY)
                .sellingType(ProductSellingType.SELLING)
                .name("ame")
                .price(4000)
                .build();

        Product product3 = Product.builder()
                .productNumber("003")
                .type(ProductType.BOTTLE)
                .sellingType(ProductSellingType.HOLD)
                .name("ame")
                .price(4000)
                .build();

        Product product4 = Product.builder()
                .productNumber("004")
                .type(ProductType.HANDMADE)
                .sellingType(ProductSellingType.STOP_SELLING)
                .name("ame")
                .price(4000)
                .build();

        productRepository.saveAll(List.of(product,product2,product3,product4));

        List<Product> products = productRepository.findAllByProductNumberIn(List.of("001", "002"));

        assertThat(products).hasSize(2)
                .extracting("productNumber","name","sellingType")
                .containsExactlyInAnyOrder(
                        tuple("001", "ame", ProductSellingType.SELLING),
                        tuple("002", "ame", ProductSellingType.SELLING)
                );
    }
}