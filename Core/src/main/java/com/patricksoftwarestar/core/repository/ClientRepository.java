package com.patricksoftwarestar.core.repository;


import com.patricksoftwarestar.core.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ClientRepository extends MongoRepository<Client, String> {
    List<Client> findByNameContains(String name);
}
