package com.patricksoftwarestar.star.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductDTO(@NotBlank String name,@NotNull BigDecimal price) {

}
