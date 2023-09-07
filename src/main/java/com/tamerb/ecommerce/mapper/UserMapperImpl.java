package com.tamerb.ecommerce.mapper;


import com.tamerb.ecommerce.business.dto.UserDto;
import com.tamerb.ecommerce.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto(user.getId(), user.getUsername(), user.getName(), user.getEmail(), user.getRole());
    }
}