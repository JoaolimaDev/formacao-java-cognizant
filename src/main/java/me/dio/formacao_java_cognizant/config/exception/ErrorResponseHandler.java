package me.dio.formacao_java_cognizant.config.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ErrorResponseHandler {
    private String status;
    private String message;
}
