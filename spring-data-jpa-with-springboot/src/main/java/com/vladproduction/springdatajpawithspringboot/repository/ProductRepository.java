package com.vladproduction.springdatajpawithspringboot.repository;

import com.vladproduction.springdatajpawithspringboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    /** returns found product entry by using its name as search criteria;
     *  if not found - returns null; */
    Product findByName(String name);

    /** returns found product entry by using its id as search criteria;
     *  if not found - returns empty Optional; */
    Optional<Product> findById(Long id);

    /** returns list of products entry by using its name or description as search criteria given as parameters;
     *  if not found - returns empty list; */
    List<Product> findByNameOrDescription(String name, String description);

    /** returns list of products entry by using its name and description as search criteria given as parameters;
     *  if not found - returns empty list; */
    List<Product> findByNameAndDescription(String name, String description);

    /** return distinct product entry whose name is given as a method parameter;
     * if not found return null */
    Product findDistinctByName(String name);

    /** returns list of products entry whose price is greater as given price as parameter;
     *  if not found - returns empty list; */
    List<Product> findByPriceGreaterThan(BigDecimal price);

    /** returns list of products entry whose price is less as given price as parameter;
     *  if not found - returns empty list; */
    List<Product> findByPriceLessThan(BigDecimal price);

    /** returns list of products entry as filter using 'like' under the hood by name given as a parameter;
     * if not found - returns empty list; */
    List<Product> findByNameContaining(String name);

    /** returns list of products entry as filter using 'like' as a predicate given as a parameter;
     * if not found - returns empty list; */
    List<Product> findByNameLike(String name);

    /** returns list of products entry based on the price ranged start-price and end-price;
     * */
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    /** returns list of products entry based on the dateCreated ranged start-date and end-date;
     * */
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    /** returns list of products entry based on multiple values;
     * */
    List<Product> findByNameIn(List<String> names);

    /** limit of query results based on find first
     * */
    List<Product> findFirst2ByOrderByNameAsc();

    /** limit of query results based on find top
     * */
    List<Product> findTop2ByOrderByPriceDesc();

}
