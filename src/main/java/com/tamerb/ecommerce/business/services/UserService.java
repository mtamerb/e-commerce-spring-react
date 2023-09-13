package com.tamerb.ecommerce.business.services;

import com.tamerb.ecommerce.entities.User;
import com.tamerb.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> listAllUser(){
        List<User> list = userRepository.findAll();
        return list;
    }

}
