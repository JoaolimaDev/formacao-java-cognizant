package me.dio.formacao_java_cognizant.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import me.dio.formacao_java_cognizant.config.exception.CustomException;
import me.dio.formacao_java_cognizant.config.exception.ErrorResponseHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponseHandler> handleCustomException(CustomException ex) {
        ErrorResponseHandler errorResponse = new ErrorResponseHandler(ex.getStatus().name(), ex.getMessage());

        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponseHandler> handleUnexpectedException(Throwable ex) {

        var msg = "Ocorreu um erro inesperado!";
        ErrorResponseHandler errorResponse = new ErrorResponseHandler(HttpStatus.INTERNAL_SERVER_ERROR.name(), msg);
        logger.error(msg,ex);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
