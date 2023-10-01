package com.patricksoftwarestar.star.service;

import com.patricksoftwarestar.star.model.Client;
import com.patricksoftwarestar.star.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client save(@Valid Client clientDTO){
        var client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        return clientRepository.save(client);
    }

    public List<Client> getAllProducts() {
        return clientRepository.findAll();
    }

    public Optional<Client> getProductById(UUID id) {
        return clientRepository.findById(id);
    }

    public void deleteById(UUID id) {
        clientRepository.deleteById(id);
    }
}
