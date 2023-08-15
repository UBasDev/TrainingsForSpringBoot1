package org.group1.repositories;

import org.group1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findFirstByName(String name);
}
