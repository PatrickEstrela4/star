package com.patricksoftwarestar.star.controller;

import com.patricksoftwarestar.star.dto.ProductDTO;
import com.patricksoftwarestar.star.model.Product;
import com.patricksoftwarestar.star.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class productController {

    @Autowired
    ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid ProductDTO productDTO){
        var product = productService.save(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
