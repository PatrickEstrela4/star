package com.patricksoftwarestar.star.service.registration;

import com.patricksoftwarestar.star.dto.ClientDTO;
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
public class ClientService extends RegistrationService{

    @Autowired
    ClientRepository clientRepository;

    public Client save(@Valid ClientDTO clientDTO){
        var client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(UUID id) {
        return clientRepository.findById(id);
    }

    public void deleteById(UUID id) {
        clientRepository.deleteById(id);
    }

    public void deleteAll(){
        clientRepository.deleteAll();
    }
}
