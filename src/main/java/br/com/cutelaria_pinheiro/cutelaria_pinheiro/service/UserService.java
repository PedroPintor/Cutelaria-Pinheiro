package br.com.cutelaria_pinheiro.cutelaria_pinheiro.service;

import java.util.UUID;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.User;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository.UserRepository;



@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public Optional<User> findById(UUID id){
        return userRepository.findById(id);
    }


}
