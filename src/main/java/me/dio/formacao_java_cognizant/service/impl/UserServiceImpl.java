package me.dio.formacao_java_cognizant.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.dio.formacao_java_cognizant.config.exception.CustomException;
import me.dio.formacao_java_cognizant.domain.model.User;
import me.dio.formacao_java_cognizant.domain.repository.UserRepository;
import me.dio.formacao_java_cognizant.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
        .orElseThrow(() -> new CustomException("Usuário não encontrado com o id: " + id, HttpStatus.BAD_REQUEST));
    }

    @Override
    public User create(User user) {
        
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
           throw new CustomException("O número de conta já foi previamente cadastrado!", HttpStatus.BAD_REQUEST);
        }
    
        return userRepository.save(user);
         
    }
    
}
