package com.tamerb.ecommerce.business.services;

import com.tamerb.ecommerce.entities.User;
import com.tamerb.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> listAllUser(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public void deleteAllUser() {
        userRepository.deleteAll();
    }
}
