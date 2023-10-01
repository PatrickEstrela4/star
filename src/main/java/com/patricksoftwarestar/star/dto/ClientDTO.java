package com.patricksoftwarestar.star.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
public record ClientDTO(@NotBlank String name, @NotNull String cpf) {
}
