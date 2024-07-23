package com.patricksoftwarestar.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Service {
    private String id;
    private Vehicle vehicle;
    private Client client;
    private String Description;
}
