package com.tamerb.ecommerce.mapper;

import com.tamerb.ecommerce.business.dto.UserDto;
import com.tamerb.ecommerce.entities.User;

public interface UserMapper {

    UserDto toUserDto(User user);
}