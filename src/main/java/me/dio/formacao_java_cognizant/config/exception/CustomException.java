package me.dio.formacao_java_cognizant.config.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CustomException extends RuntimeException {

    private HttpStatus status;

    public CustomException(String message, HttpStatus status) {
        super(message);
        this.status = status; 
    }
}
