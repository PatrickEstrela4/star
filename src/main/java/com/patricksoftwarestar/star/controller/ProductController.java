package com.patricksoftwarestar.star.controller;

import com.patricksoftwarestar.star.dto.ProductDTO;
import com.patricksoftwarestar.star.model.Product;
import com.patricksoftwarestar.star.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid ProductDTO productDTO){
        var product = productService.save(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts(){
        var products = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id){
        var product = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product.orElse(null));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID id){
        productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("produto "+id+" deletado");
    }
}
