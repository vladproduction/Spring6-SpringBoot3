package com.vladproduction.springdatajpawithspringboot.repository;

import com.vladproduction.springdatajpawithspringboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod(){
        Product product = productRepository.findByName("product1");
        System.out.println("product.getId() = " + product.getId());
        System.out.println("product.getName() = " + product.getName());
        System.out.println("product.getDescription() = " + product.getDescription());
    }

    @Test
    void findByIdMethod(){
        Product product = productRepository.findById(6L).get();
        System.out.println("product.getId() = " + product.getId());
        System.out.println("product.getName() = " + product.getName());
        System.out.println("product.getDescription() = " + product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod(){
        List<Product> products = productRepository.findByNameOrDescription("product1", "product1 description");
        products.forEach((product)->{
            System.out.println("product.getId() = " + product.getId());
            System.out.println("product.getName() = " + product.getName());
        });
    }

    @Test
    void findByNameAndDescriptionMethod(){
        List<Product> products = productRepository.findByNameAndDescription("product1", "product1 description");
        products.forEach((product)->{
            System.out.println("product.getId() = " + product.getId());
            System.out.println("product.getName() = " + product.getName());
        });
    }

    @Test
    void findDistinctByNameMethod(){
        Product product = productRepository.findDistinctByName("product1");
        System.out.println("product.getId() = " + product.getId());
        System.out.println("product.getName() = " + product.getName());
        System.out.println("product.getDescription() = " + product.getDescription());
    }

    @Test
    void findByPriceGreaterThanMethod(){
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(1000));
        products.forEach((product)->{
            System.out.println("product.getId() = " + product.getId());
            System.out.println("product.getName() = " + product.getName());
        });
    }

    @Test
    void findByPriceLessThanMethod(){
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(2000));
        products.forEach((product)->{
            System.out.println("product.getId() = " + product.getId());
            System.out.println("product.getName() = " + product.getName());
        });
    }

    @Test
    void findByNameContainingMethod(){
//        List<Product> products = productRepository.findByNameContaining("product");
//        products.forEach((product)->{
//            System.out.println("product.getId() = " + product.getId());
//            System.out.println("product.getName() = " + product.getName());
//        });

        for (Product product : productRepository.findByNameContaining("prod")) {
            System.out.println("product.getName() = " + product.getName());
        }
    }

    @Test
    void findByNameLikeMethod(){
        List<Product> products = productRepository.findByNameLike("product1");
        products.forEach((product)->{
            System.out.println("product.getId() = " + product.getId());
            System.out.println("product.getName() = " + product.getName());
        });
    }

    @Test
    void findByPriceBetweenMethod(){
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(1000), new BigDecimal(3000));
        products.forEach((product)->{
            System.out.println("product.getId() = " + product.getId());
            System.out.println("product.getName() = " + product.getName());
        });
    }

    @Test
    void findByDateCreatedBetweenMethod(){
        //startDate: 2024-06-05 16:58:38.498381
        LocalDateTime startDate = LocalDateTime.of(2024, 06, 05, 16, 58, 37);
        //endDate: 2024-06-05 20:22:57.942912
        LocalDateTime endDate = LocalDateTime.of(2024, 06, 05, 20, 23, 00);

        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);
        products.forEach((product)->{
            System.out.println("product.getId() = " + product.getId());
            System.out.println("product.getName() = " + product.getName());
        });
    }

    @Test
    void findByNameInMethod(){
        List<Product> products = productRepository.findByNameIn(List.of("product1", "product2"));
        products.forEach((product)->{
            System.out.println("product.getId() = " + product.getId());
            System.out.println("product.getName() = " + product.getName());
        });
    }

    @Test
    void findFirst2ByOrderByNameAscMethod(){
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();
        products.forEach((product)->{
            System.out.println("product.getId() = " + product.getId());
            System.out.println("product.getName() = " + product.getName());
        });
    }

    @Test
    void findTop2ByOrderByPriceDescMethod(){
        List<Product> products = productRepository.findTop2ByOrderByPriceDesc();
        products.forEach((product)->{
            System.out.println("product.getId() = " + product.getId());
            System.out.println("product.getName() = " + product.getName());
        });
    }


}
