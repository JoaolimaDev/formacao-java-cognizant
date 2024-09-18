package me.dio.formacao_java_cognizant.service.impl;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
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
        .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o id: " + id));
    }
    

    @Override
    public User create(User user) {
        
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException("O número de conta já foi previamente cadastrado!");
        }
    
        return userRepository.save(user);
       
    }
    
}
