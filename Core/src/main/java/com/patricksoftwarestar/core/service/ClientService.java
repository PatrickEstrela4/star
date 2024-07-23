package com.patricksoftwarestar.core.service;

import com.patricksoftwarestar.core.model.Client;
import com.patricksoftwarestar.core.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(String id) {
        return clientRepository.findById(id);
    }

    public List<Client> getClientByName(String name) {
        return clientRepository.findByNameContains(name);
    }

    public void deleteById(String id) {
        clientRepository.deleteById(id);
    }

    public void deleteAll() {
        clientRepository.deleteAll();
    }
}
