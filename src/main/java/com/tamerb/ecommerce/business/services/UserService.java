package com.tamerb.ecommerce.business.services;

import com.tamerb.ecommerce.business.dto.UserDto;
import com.tamerb.ecommerce.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

   List<User> getUsers();

   Optional<User> getUserByUsername(String username);

   boolean hasUserWithUsername(String username);

   boolean hasUserWithEmail(String email);

   User validateAndGetUserByUsername(String username);

   User saveUser(User user);

   void deleteUser(User user);

   Optional<User> validUsernameAndPassword(String username, String password);
}
