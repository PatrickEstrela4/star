package com.patricksoftwarestar.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Client {

    @Id
    private String id;
    private String name;
    private String cpf;
    private String phone;
    private List<Vehicle> vehicles;
}
