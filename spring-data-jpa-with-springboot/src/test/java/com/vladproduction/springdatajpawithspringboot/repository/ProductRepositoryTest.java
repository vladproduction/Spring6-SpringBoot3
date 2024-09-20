package com.vladproduction.springdatajpawithspringboot.repository;

import com.vladproduction.springdatajpawithspringboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        //create product
        Product product = new Product();
        product.setActive(true);
        product.setName("product1");
        product.setDescription("product1 description");
        product.setSku("ABC-product1");
        product.setPrice(new BigDecimal(1000));
        product.setImageUrl("product1.png");

        //save product
        Product savedProduct1 = productRepository.save(product);

        //create product
        Product product2 = new Product();
        product2.setActive(true);
        product2.setName("product2");
        product2.setDescription("product2 description");
        product2.setSku("ABC-product2");
        product2.setPrice(new BigDecimal(2000));
        product2.setImageUrl("product2.png");

        //save product
        Product savedProduct2 = productRepository.save(product2);

        //create product
        Product product3 = new Product();
        product3.setActive(true);
        product3.setName("product3");
        product3.setDescription("product3 description");
        product3.setSku("ABC-product3");
        product3.setPrice(new BigDecimal(3000));
        product3.setImageUrl("product3.png");

        //save product
        Product savedProduct3 = productRepository.save(product3);


    }

    @Test
    void updateMethod(){
        //find or retrieve an entity by id:
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        //update some fields of existing entity:
        product.setName("PRODUCT-1 (updated)");
        product.setDescription("description: PRODUCT-1 (updated)");

        //save updated entity into DB:
        productRepository.save(product);
    }

    @Test
    void findByIdMethod(){
        //find by id:
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        //display:
        System.out.println("product = " + product);
    }

    @Test
    void saveAllMethod(){

        //create product
        Product product = new Product();
        product.setActive(true);
        product.setName("product4");
        product.setDescription("product4 description");
        product.setSku("ABC-product4");
        product.setPrice(new BigDecimal(2000));
        product.setImageUrl("product4.png");

        Product product2 = new Product();
        product2.setActive(true);
        product2.setName("product5");
        product2.setDescription("product5 description");
        product2.setSku("ABC-product5");
        product2.setPrice(new BigDecimal(3000));
        product2.setImageUrl("product5.png");

        productRepository.saveAll(List.of(product, product2));
    }

    @Test
    void findAllMethod(){
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            System.out.println(product);
        }
        //retrieving by lambda:
        products.forEach((product -> {
            System.out.println(product);
        }));
        //retrieving by method reference:
        products.forEach((System.out::println));
    }

    @Test
    void deleteByIdMethod(){
        Long id = 5L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){
        //find an entity by id
        Long id = 4L;
        Product product = productRepository.findById(id).get();
        //delete (entity)
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod(){
        productRepository.deleteAll();
    }

    @Test
    void deleteAllSpecificMethod(){
        Product product4 = productRepository.findById(7L).get();
        Product product5 = productRepository.findById(8L).get();
        productRepository.deleteAll(List.of(product4, product5));
    }

    @Test
    void countMethod(){
        long count = productRepository.count();
        System.out.println("count = " + count);
    }

    @Test
    void existByIdMethod(){
        Long id = 6L;
        boolean existsById = productRepository.existsById(id);
        System.out.println("existsById = " + existsById);
    }


}