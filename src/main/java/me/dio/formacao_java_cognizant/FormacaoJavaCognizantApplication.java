package me.dio.formacao_java_cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition( servers= { @Server( url="/", description = "Default Server root") } )
public class FormacaoJavaCognizantApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormacaoJavaCognizantApplication.class, args);
	}

}
