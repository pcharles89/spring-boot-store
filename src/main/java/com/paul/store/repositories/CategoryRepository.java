package com.paul.store.repositories;

import com.paul.store.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Byte> {
    Optional<Category> findByName(String name);
}