package com.patricksoftwarestar.star.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ClientDTO(@NotBlank String name, @NotNull String cpf) {
}
