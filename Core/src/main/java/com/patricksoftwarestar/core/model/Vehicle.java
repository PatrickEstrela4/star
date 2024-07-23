package com.patricksoftwarestar.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Vehicle {

    @Id
    private String id;
    private CarModel model;
    private CarBrand brand;
    private String registrationPlate;
    private int year;
}