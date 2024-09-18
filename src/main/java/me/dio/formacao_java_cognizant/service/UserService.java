package me.dio.formacao_java_cognizant.service;

import me.dio.formacao_java_cognizant.domain.model.User;

public interface UserService {
    
    User findById(Long id);
    User create(User userReceived);
}
