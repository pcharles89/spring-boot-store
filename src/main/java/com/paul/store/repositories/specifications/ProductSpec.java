package com.paul.store.repositories.specifications;

import com.paul.store.entities.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductSpec {

    public static Specification<Product> hasName(String name) {
        return (root, query, cb) -> {
            if (name == null || name.isBlank()) {
                return null;
            }
            return cb.equal(root.get("name"), name);
        };
    }

    public static Specification<Product> hasPriceGreaterThanOrEqualTo(BigDecimal price) {
        return (root, query, cb) -> {
            if (price == null) {
                return null;
            }
            return cb.greaterThanOrEqualTo(root.get("price"), price);
        };
    }
}


