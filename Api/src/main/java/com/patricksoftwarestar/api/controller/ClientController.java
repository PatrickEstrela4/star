package com.patricksoftwarestar.api.controller;

import com.patricksoftwarestar.core.model.Client;
import com.patricksoftwarestar.core.service.ClientService;
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
    public ResponseEntity<Client> saveClient(Client clientDTO) {
        var client = productService.save(clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @GetMapping("/client")
    public ResponseEntity<List<Client>> getAllClients() {
        var client = productService.getAllClients();
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable(value = "id") String id) {
        var product = productService.getClientById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product.orElse(null));
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable(value = "id") String id) {
        productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("client " +  id + "deletado");
    }
}
