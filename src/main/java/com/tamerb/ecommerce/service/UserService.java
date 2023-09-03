package com.tamerb.ecommerce.service;

import com.tamerb.ecommerce.dto.RegisterDto;
import com.tamerb.ecommerce.dto.ResponseDto;
import com.tamerb.ecommerce.model.User;
import com.tamerb.ecommerce.repository.UserRepository;
import jakarta.xml.bind.DatatypeConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;


@RequiredArgsConstructor
@Log4j2

@Service
public class UserService {

    private final UserRepository userRepository;

    public ResponseDto register(RegisterDto registerDto) {
        if (Objects.nonNull(userRepository.findByEmail(registerDto.getEmail()))) {
            return new ResponseDto("User already exists", HttpStatus.BAD_REQUEST);
        }

        String encryptedPassword = registerDto.getPassword();

        try {
            encryptedPassword = encryptPassword(registerDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            log.error("Error while hashing password", e);
        }
        User user = new User(registerDto.getFirstName(), registerDto.getLastName(),
                registerDto.getEmail(), encryptedPassword);

        userRepository.save(user);
        return new ResponseDto("User registered successfully", HttpStatus.OK);
    }

    private String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(password.getBytes());
        byte[] digest = messageDigest.digest();
        return DatatypeConverter.printHexBinary(digest).toLowerCase();
    }
}
