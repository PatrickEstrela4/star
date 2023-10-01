package com.patricksoftwarestar.star.controller;

import com.patricksoftwarestar.star.model.Client;
import com.patricksoftwarestar.star.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ClientController {

    @Autowired
    ClientService productService;

    @PostMapping("/client")
    public ResponseEntity<Client> saveProduct(@RequestBody @Valid Client clientDTO){
        var product = productService.save(clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/client")
    public ResponseEntity<List<Client>> getAllProducts(){
        var products = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getProductById(@PathVariable(value="id") UUID id){
        var product = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product.orElse(null));
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(value="id") UUID id){
        productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("client " + id + "deletado");
    }
}
