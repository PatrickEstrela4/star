package com.patricksoftwarestar.star.repository;

import com.patricksoftwarestar.star.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
