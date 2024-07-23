package com.patricksoftwarestar.core.repository;

import com.patricksoftwarestar.core.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByNameContains(String name);
}
