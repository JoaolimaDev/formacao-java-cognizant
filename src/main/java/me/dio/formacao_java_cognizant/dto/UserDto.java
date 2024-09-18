package me.dio.formacao_java_cognizant.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserDto(@NotNull @NotEmpty(message = "O campo nome precisa ser preenchido!") String name,
   @NotEmpty(message = "O número da conta precisa ser preenchido!") @NotNull String accountNumber) {
    
}
