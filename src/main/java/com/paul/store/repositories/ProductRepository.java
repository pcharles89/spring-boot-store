package com.paul.store.repositories;

import com.paul.store.dto.ProductSummary;
import com.paul.store.entities.Category;
import com.paul.store.entities.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductCriteriaRepository, JpaSpecificationExecutor<Product> {

    //JPQL
    @Query("select p from Product p where p.price between :min and :max order by p.name")
    List<Product> findProducts(BigDecimal min, BigDecimal max);

    //Derived
    List<Product> findByPriceBetweenOrderByNameAsc(BigDecimal min, BigDecimal max);

    //SQL
    @Query(
            value = """
        SELECT p.*
        FROM products p
        WHERE p.price BETWEEN :min AND :max
        ORDER BY p.name ASC
    """,
            nativeQuery = true
    )
    List<Product> findProductsNative(@Param("min") BigDecimal min,
                                     @Param("max") BigDecimal max);


    List<ProductSummary> findByCategory(Category category);

    @EntityGraph(attributePaths = "category")
    List<Product> findByCategoryId(Byte categoryId);

    @EntityGraph(attributePaths = "category")
    @Query("SELECT p FROM Product p")
    List<Product> findAllWithCategory();

}